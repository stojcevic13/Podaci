from queue1 import Queue


class TreeNode(object):

    def __init__(self, value, parent=None, children=None):
        self._value = value
        self._parent = parent
        if parent:
            parent.add_child(self)

        if children is None:
            children = []
        self._children = children

    @property
    def value(self):
        return self._value

    @property
    def parent(self):
        return self._parent

    @property
    def children(self):
        return self._children

    @value.setter
    def value(self, value):
        self._value = value

    @parent.setter
    def parent(self, parent):
        self._parent = parent

    def is_root(self):
        return self._parent is None

    def is_leaf(self):
        return self._children == []

    def add_child(self, child):
        self._children.append(child)

    def __str__(self):
        return str(self._value)


class Tree(object):

    def __init__(self, root=None):
        self._root = root

    @property
    def root(self):
        return self._root

    @root.setter
    def root(self, root):
        self._root = root

    def is_empty(self):
        return self._root is None

    def depth(self, node):
        if node.parent is None:
            return 0
        else:
            return 1 + self.depth(node.parent)

    def preorder(self):
        self._preorder(self._root)

    def _preorder(self, node):
        print(node)
        for child in node.children:
            self._preorder(child)

    def postorder(self):
        self._postorder(self._root)

    def _postorder(self, node):
        for child in node.children:
            self._postorder(child)
        print(node)

    def breath_first(self):
        queue = Queue(50)
        queue.enqueue(self._root)
        self._breath_first(queue)

    def _breath_first(self, queue):
        if not queue.is_empty():
            node = queue.dequeue()
            print(node)
            for child in node.children:
                queue.enqueue(child)
            self._breath_first(queue)

    def height(self):
        return self._height(self._root)

    def _height(self, node):
        if node.is_leaf():
            return 0
        else:
            return 1 + max(self._height(child) for child in node.children)


if __name__ == '__main__':
    node1 = TreeNode(1)
    node2 = TreeNode(2, node1)
    node3 = TreeNode(3, node1)
    node7 = TreeNode(7, node1)
    node4 = TreeNode(4, node2)
    node5 = TreeNode(5, node2)

    tree = Tree(node1)
    print(tree.height())
