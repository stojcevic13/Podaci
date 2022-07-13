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

    # def append(self, value):
    #     node = Node(value)
    #     if self._head is None:
    #         self._head = node
    #     else:
    #         current = self._head
    #         while current.next_node:
    #             current = current.next_node
    #         current.next_node = node

    def __iter__(self):
        current = self._head
        while current is not None:
            yield current.value
            current = current.next_node

    def __len__(self):
        return self._size
        # if not self._head:
        #     return 0
        # else:
        #     size = 1
        #     current = self._head
        #     while current.next_node:
        #         size += 1
        #         current = current.next_node
        #     return size

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


if __name__ == '__main__':
    list1 = SinglyLinkedList()
    list1.add_last(3)
    list1.add_last(4)
    list1.add_last(5)
    list1.add_first(2)
    list1[2] = 54
    del list1[1]
    print(list1[1])

    for elem in list1:
        print(elem)
