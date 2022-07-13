import numpy as np
from line import Line
from point import Point
from math import atan, pi


def create_line(point1, point2):
    x1, y1, x2, y2 = point1.x, point1.y, point2.x, point2.y
    k = (y2 - y1) / (x2 - x1)
    n = y1 - k * x1
    return Line(k, n)


def angle_between_lines(k1, k2):
    tg_alpha = (k2 - k1) / (1 + k1*k2)
    alpha = atan(tg_alpha)
    return alpha if alpha > 0 else (alpha + 2*pi)


if __name__ == '__main__':
    point1 = Point(-5, -2)
    point2 = Point(7, 6)
    line = create_line(point1, point2)

    alpha = angle_between_lines(-1, 100)
    print(alpha)
