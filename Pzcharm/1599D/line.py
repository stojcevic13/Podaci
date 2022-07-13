
class Line(object):

    def __init__(self, k, n):
        self._k = k
        self._n = n

    @property
    def k(self):
        return self._k

    @property
    def n(self):
        return self._n

    @n.setter
    def n(self, n):
        self._n = n

    def __str__(self):
        return f'k= {self._k}   n= {self._n}'
