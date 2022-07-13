from line import Line


class Player(object):

    def __init__(self, dx, dy, k):
        self._dx = dx
        self._dy = dy
        self._k = k
        n = -1000000000 if ((dx > 0 and dy < 0) or (dx > 0 and dy > 0)) else 1000000000
        self._line = Line(dy/dx, n)
        self._popped_bubbles = []

    @property
    def k(self):
        return self._k

    @property
    def dx(self):
        return self._dx

    @property
    def dy(self):
        return self._dy

    @property
    def line(self):
        return self._line

    @property
    def popped_bubbles(self):
        return self._popped_bubbles

    @line.setter
    def line(self, line):
        self._line = line
