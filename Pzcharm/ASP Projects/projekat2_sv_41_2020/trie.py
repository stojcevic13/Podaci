from difflib import SequenceMatcher


def similar(a, b):
    return SequenceMatcher(None, a, b).ratio()


class TrieNode(object):

    def __init__(self):
        self._children = {}
        self._is_end_of_word = False
        self._data = []
        self._starts_data = []

    @property
    def children(self):
        return self._children

    @property
    def is_end_of_word(self):
        return self._is_end_of_word

    @property
    def data(self):
        return self._data

    @property
    def starts_data(self):
        return self._starts_data

    @is_end_of_word.setter
    def is_end_of_word(self, value):
        self._is_end_of_word = value

    @data.setter
    def data(self, data):
        self._data = data


class Trie(object):

    def __init__(self):
        self._root = TrieNode()

    def insert(self, word, data=None):
        """Ubacuje rijec u trie"""
        curr = self._root
        for ch in word:
            if ch not in curr.children:
                curr.children[ch] = TrieNode()
            curr = curr.children[ch]
            curr.starts_data.append(data)
        curr.is_end_of_word = True
        curr.data.append(data)

    def search(self, word):
        """Vraca True ili False u zavisnosti od toga da li postoji trazena rijec"""
        curr = self._root
        for ch in word:
            if ch not in curr.children:
                return False
            curr = curr.children[ch]

        if curr.is_end_of_word:
            return True, curr.data
        return False

    def starts_with(self, prefix):
        """Vraca True ako postoji rijec koja pocinje sa..."""
        curr = self._root
        for ch in prefix:
            if ch not in curr.children:
                return False, None
            curr = curr.children[ch]

        return True, curr.starts_data

    def find_similar(self, word):
        sim_nums = []
        for node in self._root.children.values():
            for info in node.starts_data:
                number = info.split(',')[2]
                similarity = similar(word, number)
                if similarity > 0.75:
                    sim_nums.append(number)
                    if len(sim_nums) >= 3:
                        return sim_nums
        return sim_nums
