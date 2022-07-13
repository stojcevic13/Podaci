class Rectange(object):
    def __init__(self, a, b):
        self._a = a
        self._b = b

    @property
    def a(self):
        return self._a

    @property
    def b(self):
        return self._b

    @a.setter
    def a(self, a):
        self._a = a

    @b.setter
    def b(self, b):
        self._b = b

    def obim(self):
        return 2*self._a + 2*self._b

    def povrsina(self):
        return self._a * self._b


class Square(Rectange):
    def __init__(self, a):
        super().__init__(a, a)


if __name__ == "__main__":
    rect1 = Rectange(3, 5)
    rect1.a = 5

    square1 = Square(5)
    print(square1.obim())
    print(square1.povrsina())
