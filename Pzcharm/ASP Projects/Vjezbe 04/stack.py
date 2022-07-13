class EmptyStackError(Exception):
    pass


class FullStackError(Exception):
    pass


class Stack(object):

    def __init__(self, capacity=10):
        self._data = []
        self._capacity = capacity

    def __len__(self):
        return len(self._data)

    def is_empty(self):
        return len(self._data) == 0

    def push(self, e):
        if len(self._data) >= self._capacity:
            raise FullStackError("Stek je pun!")
        self._data.append(e)

    def top(self):
        if self.is_empty():
            raise EmptyStackError("Stek je prazan!")
        return self._data[-1]

    def pop(self):
        if self.is_empty():
            raise EmptyStackError("Stek je pun!")
        return self._data.pop()




if __name__ == "__main__":
    stack1 = Stack()
    stack1.push(4)
    print(stack1.pop())
    print(stack1.top())
    print(stack1.pop())
