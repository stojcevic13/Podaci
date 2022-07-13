from zadatak1 import Element


class EmptyHeapException(Exception):
    pass


class Heap(object):

    def __init__(self):
        self._data = []
        self._size = 0

    def __len__(self):
        return self._size

    def is_empty(self):
        return len(self) == 0

    def left_child(self, index):
        return 2*index + 1

    def _has_left_child(self, index):
        return (2*index + 1) <= len(self)-1

    def right_child(self, index):
        return 2*index + 2

    def _has_right_child(self, index):
        return (2*index + 2) <= len(self)-1

    def parent(self, index):
        return (index - 1) // 2

    def _swap(self, index1, index2):
        self._data[index1], self._data[index2] = self._data[index2], self._data[index1]

    def add(self, key, value):
        new_element = Element(key, value)
        if self.is_empty():
            self._data.append(new_element)
        else:
            self._data.append(new_element)
            self._upheap(self._size)
        self._size += 1

    def _upheap(self, index):
        parent = self.parent(index)
        if index == 0 or self._data[index] > self._data[parent]:
            return
        else:
            self._swap(index, parent)
            self._upheap(parent)

    def min(self):
        return self._data[0]

    def remove_min(self):
        if self.is_empty():
            raise EmptyHeapException("Heap is empty!")

        self._swap(0, len(self)-1)
        min_elem = self._data.pop(len(self)-1)
        self._size -= 1
        self._downheap(0)
        return min_elem

    def _downheap(self, index):
        if not self._has_left_child(index):
            return

        min_index, min_elem = index, self._data[index]
        if self._has_left_child(index):
            min_elem = min(self._data[index], self._data[self.left_child(index)])
            min_index = self._data.index(min_elem)

        if self._has_right_child(index):
            min_elem = min(min_elem, self._data[self.right_child(index)])
            min_index = self._data.index(min_elem)

        if min_index != index:
            self._swap(index, min_index)
            self._downheap(min_index)

    def __str__(self):
        return "[" + ", ".join(str(elem) for elem in self._data) + "]"


# dsdasdsadsads
# dasdsadsdasdsad
# sadsadsadasdas
# dasdasdsadsad
# dasdsadsadsa
# asdadadasdasd


class MinHeap(object):

    def __init__(self, data):
        self._data = data
        self._size = len(data)
        self.build_min_heap()

    def __len__(self):
        return self._size

    def is_empty(self):
        return len(self) == 0

    def left_child(self, index):
        return 2*index + 1

    def _has_left_child(self, index):
        return (2*index + 1) <= len(self)-1

    def right_child(self, index):
        return 2*index + 2

    def _has_right_child(self, index):
        return (2*index + 2) <= len(self)-1

    def parent(self, index):
        return (index - 1) // 2

    def _swap(self, index1, index2):
        self._data[index1], self._data[index2] = self._data[index2], self._data[index1]

    def add(self, key, value):
        new_element = Element(key, value)
        if self.is_empty():
            self._data.append(new_element)
        else:
            self._data.append(new_element)
            self._upheap(self._size)
        self._size += 1

    def _upheap(self, index):
        parent = self.parent(index)
        if index == 0 or self._data[index] > self._data[parent]:
            return
        else:
            self._swap(index, parent)
            self._upheap(parent)

    def min(self):
        return self._data[0]

    def remove_min(self):
        if self.is_empty():
            raise EmptyHeapException("Heap is empty!")

        self._swap(0, len(self)-1)
        min_elem = self._data.pop(len(self)-1)
        self._size -= 1
        self._downheap(0)
        return min_elem

    def _downheap(self, index):
        if not self._has_left_child(index):
            return

        left_child, right_child = self.left_child(index), self.right_child(index)

        min_index, min_elem = index, self._data[index]
        if self._has_left_child(index) and self._data[left_child] < self._data[index]:
            min_index = left_child

        if self._has_right_child(index) and self._data[right_child] < self._data[min_index]:
            min_index = right_child

        if min_index != index:
            self._swap(index, min_index)
            self._downheap(min_index)

    def build_min_heap(self):
        start_index = (len(self) // 2) - 1
        for index in range(start_index, -1, -1):
            self._downheap(index)

    def __str__(self):
        return "[" + ", ".join(str(elem) for elem in self._data) + "]"


def heap_sort(unsorted_list):
    sorted_list = []
    min_heap = MinHeap(unsorted_list)
    while not min_heap.is_empty():
        sorted_list.append(min_heap.remove_min())
    return sorted_list


if __name__ == '__main__':
    # heap = Heap()
    # heap.add(1, "elem1")
    # heap.add(2, "elem2")
    # heap.add(3, "elem3")
    # heap.add(5, "elem4")
    # heap.add(7, "elem5")
    # heap.add(8, "elem6")
    # heap.add(11, "elem7")
    # print(heap)
    # print(heap.remove_min())
    # print(heap)

    # data = [17, 9, 11, 8, 14, 24, 13, 19, 14, 10, 12]
    # min_heap = MinHeap(data)
    # print(min_heap)

    list1 = [17, 9, 11, 8, 14, 24, 13, 19, 14, 10, 12]
    sorted_list = heap_sort(list1)
    print(sorted_list)
