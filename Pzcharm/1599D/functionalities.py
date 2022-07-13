from math import sqrt, atan, pi
import numpy as np
from line import Line


def rijesi_sistem_jednacina(a, b):
    np_a = np.array(a)
    np_b = np.array(b)
    solution = np.linalg.inv(np_a).dot(np_b)
    return solution[0], solution[1]


def point_to_line_distance(point, line):
    # point(x=0, y=0)  line(k=-1, n=-100000000)
    x1, y1, k, n = point.x, point.y, line.k, line.n

    kn = (1 / k) * -1
    nn = y1 - kn * x1

    x2, y2 = rijesi_sistem_jednacina([[k * -1, 1], [kn * -1, 1]], [n, nn])

    return sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1))


def create_line(point1, point2):
    x1, y1, x2, y2 = point1.x, point1.y, point2.x, point2.y
    k = 1000000 if (x2 - x1) == 0 else ((y2 - y1) / (x2 - x1))
    n = y1 - k * x1
    return Line(k, n)


def angle_between_lines(k1, k2):
    if (1 + k1*k2) == 0:
        return pi/2 if (k2 - k1) > 0 else 3*pi/2
    tg_alpha = (k2 - k1) / (1 + k1*k2)
    alpha = atan(tg_alpha)
    return alpha if alpha > 0 else (alpha + 2*pi)
