class QueueError(Exception):
    pass


class Queue(object):

    def __init__(self, capacity=10):
        self._data = [None] * capacity
        self._capacity = capacity
        self._first = 0
        self._size = 0

    def __len__(self):
        return self._size

    def is_empty(self):
        return self._size == 0

    def first(self):
        if self.is_empty():
            raise QueueError("Red je prazan!")
        return self._data[self._first]

    def enqueue(self, e):
        if self._size >= self._capacity:
            raise QueueError("Red je pun!")

        if self._size+1 > self._capacity:
            self.resize(self._capacity * 2)

        new_index = (self._first + self._size) % self._capacity
        self._data[new_index] = e
        self._size += 1

    def dequeue(self):
        if self.is_empty():
            raise QueueError("Red je prazan!")

        element = self._data[self._first]
        self._size -= 1
        self._data[self._first] = None
        self._first = (self._first+1) % self._capacity

        if self._size < self._capacity//4:
            self.resize(self._capacity//2)

        return element

    def resize(self, new_capacity):
        new_data = [None] * new_capacity

        for new_index in range(self._size):
            new_data[new_index] = self._data[self._first]
            self._first = (self._first+1) % self._capacity

        self._data = new_data
        self._first = 0
        self._capacity = new_capacity


if __name__ == "__main__":
    queue = Queue()
    queue.enqueue(1)
    queue.enqueue(2)
    print(queue.dequeue())
    print(queue.first())
    print(queue.is_empty())
    print(queue.dequeue())
    print(queue.is_empty())
