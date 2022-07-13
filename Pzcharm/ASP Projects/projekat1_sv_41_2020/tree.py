"""
Modul sadrži implementaciju stabla.
"""
# from queue2 import Queue


class TreeNode(object):
    """
    Klasa modeluje čvor stabla.
    """
    __slots__ = '_parent', '_children', '_state', '_move'

    def __init__(self, state, move):
        """
        Konstruktor.

        Argument:
        - `data`: podatak koji se upisuje u čvor
        """
        self._parent = None
        self._children = []
        self._state = state
        self._move = move

    @property
    def parent(self):
        return self._parent

    @property
    def children(self):
        return self._children

    @property
    def state(self):
        return self._state

    @property
    def move(self):
        return self._move

    def set_data(self, new_state):
        self._state = new_state

    def is_root(self):
        """
        Metoda proverava da li je čvor koren stabla.
        """
        return self._parent is None

    def is_leaf(self):
        """
        Metoda proverava da li je čvor list stabla.
        """
        return len(self._children) == 0

    def add_child(self, x):
        """
        Metoda dodaje potomka čvoru.

        Argument:
        - `x`: čvor potomak
        """
        # kreiranje dvosmerne veze između čvorova
        # x.parent = self
        self._children.append(x)

    def __str__(self):
        return str(self._move) + ':\n' + str(self.state)


class Tree(object):
    """
    Klasa modeluje stablo.
    """
    def __init__(self, root=None):
        self.root = TreeNode(root, None)

    def is_empty(self):
        """
        Metoda proverava da li stablo ima elemenata.
        """
        return self.root is None

    # def depth(self, x):
    #     """
    #     Metoda izračunava dubinu zadatog čvora.
    #
    #     Argument:
    #     - `x`: čvor čija dubina se računa
    #     """
    #     if x.is_root():
    #         return 0
    #     else:
    #         return 1 + self.depth(x.parent)

    # def _height(self, x):
    #     """
    #     Metoda izračunava visinu podstabla sa zadatim korenom.
    #
    #     Argument:
    #     - `x`: koren posmatranog podstabla
    #     """
    #     if x.is_leaf():
    #         return 0
    #     else:
    #         return 1 + max(self._height(c) for c in x.children)
    #
    # def height(self):
    #     return self._height(self.root)

    # def preorder(self, x):
    #     """
    #     Preorder obilazak po dubini
    #
    #     Najpre se vrši obilazak roditelja a zatim svih njegovih potomaka.
    #
    #     Argument:
    #     - `x`: čvor od koga počinje obilazak
    #     """
    #     if not self.is_empty():
    #         print(x)
    #         for c in x.children:
    #             self.preorder(c)

    # def postorder(self, x):
    #     """
    #     Postorder obilazak po dubini
    #
    #     Najpre se vrši obilazak potomaka a zatim i roditelja
    #
    #     Argument:
    #     - `x`: čvor od koga počinje obilazak
    #     """
    #     if not self.is_empty():
    #         for c in x.children:
    #             self.postorder(c)
    #         print(x.state)

    # def breadth_first(self):
    #     """
    #     Metoda vrši obilazak stabla po širini.
    #     """
    #     to_visit = Queue()
    #     to_visit.enqueue(self.root)
    #     while not to_visit.is_empty():
    #         e = to_visit.dequeue()
    #         print(e.state)
    #
    #         for c in e.children:
    #             to_visit.enqueue(c)

    # def __iter__(self):
    #     """
    #     Metoda vrši obilazak stabla po širini.
    #     """
    #     to_visit = Queue()
    #     to_visit.enqueue(self.root)
    #     while not to_visit.is_empty():
    #         e = to_visit.dequeue()
    #         yield e.state
    #
    #         for c in e.children:
    #             to_visit.enqueue(c)


# if __name__ == '__main__':
#     # instanca stabla
#     t = Tree()
#     t.root = TreeNode(0, None)
#
#     # kreiranje relacija između novih čvorova
#     a = TreeNode(1, None)
#     b = TreeNode(2, None)
#     c = TreeNode(3, None)
#
#     a.add_child(b)
#     t.root.add_child(a)
#     t.root.add_child(c)
#     a.add_child(TreeNode(45, None))
#
#     # visina stabla
#     print('Visina = %d' % t.height())
#
#     # dubina čvora
#     print('Dubina(a) = %d' % t.depth(a))
#
#     # obilazak po dubini - preorder
#     print('PREORDER')
#     t.preorder(t.root)
#
#     # obilazak po dubini - postorder
#     print('POSTORDER')
#     t.postorder(t.root)
#
#     # obilazak po širini
#     print('BREADTH FIRST')
#     t.breadth_first()
#
#     print('ITERACIJA')
#     for node in t:
#         print(node)
