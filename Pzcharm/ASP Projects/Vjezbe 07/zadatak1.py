class PriorityQueueException(Exception):
    pass


class EmptyListException(Exception):
    pass


class Node(object):

    def __init__(self, value, next_node=None):
        self._value = value
        self._next_node = next_node

    @property
    def value(self):
        return self._value

    @property
    def next_node(self):
        return self._next_node

    @value.setter
    def value(self, value):
        self._value = value

    @next_node.setter
    def next_node(self, next_node):
        self._next_node = next_node

    def __str__(self):
        return str(self._value)


class SinglyLinkedList(object):

    def __init__(self):
        self._head = None
        self._tail = None
        self._size = 0

    @property
    def head(self):
        return self._head

    @property
    def tail(self):
        return self._tail

    @property
    def size(self):
        return self._size

    def __iter__(self):
        current = self._head
        while current is not None:
            yield current.value
            current = current.next_node

    def __len__(self):
        return self._size

    def is_empty(self):
        return self._head is None

    def get_first(self):
        if self._head:
            return self._head.value
        raise EmptyListException("List is empty.")

    def get_last(self):
        if not self._head:
            raise EmptyListException("List is empty.")
        else:
            return self._tail.value

    def add_first(self, value):
        node = Node(value)
        if self._head is None:
            self._head = self._tail = node
        else:
            node.next_node = self._head
            self._head = node
        self._size += 1

    def add_last(self, value):
        node = Node(value)
        if self._head is None:
            self._head = node
        else:
            self._tail.next_node = node
        self._tail = node
        self._size += 1

    def remove_first(self):
        if not self._head:
            raise EmptyListException("List is empty.")
        if self._size == 1:
            self._tail = None

        self._head = self._head.next_node
        self._size -= 1

    def remove_last(self):
        if not self._head:
            raise EmptyListException("List is empty.")

        if self._size == 1:
            self._head = self._tail = None
        else:
            current = self._head
            while current.next_node.next_node:
                current = current.next_node
            current.next_node = None
            self._tail = current
        self._size -= 1

    def append(self, value):
        self.add_last(value)

    def extend(self, other_list):
        if other_list.is_empty():
            return
        if self.is_empty():
            self._head = other_list.head
        else:
            self._tail.next_node = other_list.head

        self._tail = other_list.tail
        self._size += other_list.size

    def _fix_index(self, index, more_than_len_allowed=False):
        if not more_than_len_allowed and (-self._size > index or index > self._size):
            raise IndexError("list index out of range")

        if index < -self._size:
            return 0
        elif index < 0:
            return self._size + index

        if index >= self._size:
            return self._size
        return index

    def _get_element_by_index(self, index):
        index = self._fix_index(index)

        current = self._head
        counter = 0
        while counter < index:
            current = current.next_node
            counter += 1
        return current

    def _get_element_by_value(self, value):
        current = self._head
        counter = 0
        while counter < self._size:
            if current.value == value:
                return current
            current = current.next_node
        return None

    def __getitem__(self, index):
        return self._get_element_by_index(index)

    def __setitem__(self, index, value):
        self._get_element_by_index(index).value = value

    def __delitem__(self, index):
        if self.is_empty():
            raise EmptyListException("List is empty.")

        if self._size == 1:
            self._head = self._tail = None
            self._size = 0
            return

        index = self._fix_index(index)
        if index == 0:
            self.remove_first()
        else:
            previous = self._get_element_by_index(index-1)
            previous.next_node = previous.next_node.next_node
            self._size -= 1

    def insert(self, index, value):
        index = self._fix_index(index)
        new_node = Node(value)
        previous = self._get_element_by_index(index-1)
        new_node.next_node = previous.next_node
        previous.next_node = new_node
        self._size += 1

    def remove(self, value):
        previous = None
        current = self._head
        while current:
            if current.value == value:
                if previous:
                    previous.next_node = current.next_node
                else:
                    self._head = current.next_node
                self._size -= 1
                return
            previous = current
            current = current.next_node
        raise ValueError(f"Value {value} is not in list.")

    def pop(self, index=-1):
        index = self._fix_index(index)
        del self[index]
        self._size -= 1

    def __add__(self, other_list):
        new_list = SinglyLinkedList()
        new_list.extend(self)
        new_list.extend(other_list)
        return new_list

    def __str__(self):
        ret = "["
        ret += ", ".join(str(item) for item in self)
        ret += "]"
        return ret


class Element(object):

    def __init__(self, key, value):
        self._key = key
        self._value = value

    @property
    def key(self):
        return self._key

    @property
    def value(self):
        return self._value

    @key.setter
    def key(self, key):
        self._key = key

    @value.setter
    def value(self, value):
        self._value = value

    def __gt__(self, other):
        return self._key > other.key

    def __lt__(self, other):
        return self._key < other.key

    def __ne__(self, other):
        return self._key != other.key

    def __le__(self, other):
        return self._key <= other.key

    def __eq__(self, other):
        return self._key == other.key

    def __ge__(self, other):
        return self._key >= other.key

    def __str__(self):
        return str(self.key) + "-" + str(self._value)


class PriorityQueueBase(object):

    def __init__(self):
        self._data = []
        self._size = 0

    def __len__(self):
        return self._size

    def is_empty(self):
        return len(self) == 0

    def __str__(self):
        return ", ".join(f"{elem.key}-{elem.value}" for elem in self._data)


class SortedPriorityQueue(PriorityQueueBase):

    def __init__(self):
        super().__init__()

    def add(self, key, value):
        new_element = Element(key, value)
        self._size += 1
        if self.is_empty():
            self._data.append(new_element)
        else:
            for current in self._data:
                if new_element < current:
                    self._data.insert(self._data.index(current), new_element)
                    return
            self._data.append(new_element)

    def min(self):
        if self.is_empty():
            raise PriorityQueueException("Priority Queue is empty.")
        return self._data[0]

    def remove_min(self):
        if self.is_empty():
            raise PriorityQueueException("Priority Queue is empty.")
        removed = self._data.pop(0)
        self._size -= 1
        return removed


class UnsortedPriorityQueue(PriorityQueueBase):

    def __init__(self):
        super().__init__()

    def add(self, key, value):
        new_element = Element(key, value)
        self._data.append(new_element)
        self._size += 1

    def min(self):
        if self.is_empty():
            raise PriorityQueueException("Priority Queue is empty.")
        return min(self._data)

    def remove_min(self):
        removed = self.min()
        del self._data[self._data.index(removed)]
        self._size -= 1
        return removed


if __name__ == '__main__':
    nemanja = Element(1, "Nemanja")
    nikola = Element(2, "Nikola")
    pq = SortedPriorityQueue()
    pq.add(1, "Nemanja")
    pq.add(2, "Nikola")
    pq.add(3, "Marko")
    pq.add(1, "Miloje")
    print(pq)
    # print(pq.min())
    # minp = pq.remove_min()
    # print(minp)
    # print(pq.min())
