import numpy as np
from math import sqrt


def diameter(points):
    num_points = np.shape(points)[0]
    max_distance = 0
    for point1 in range(num_points):
        x1, y1 = points[point1, 0], points[point1, 1]
        for point2 in range(point1, num_points):
            x2, y2 = points[point2, 0], points[point2, 1]
            distance = sqrt((x2 - x1)**2 + (y2 - y1)**2)
            if distance > max_distance:
                max_distance = distance
    return max_distance


if __name__ == '__main__':
    m = np.array([
        [1.0, 0.0],
        [4.0, 8.0],
        [2.1, 1.2],
        [3.2, 1.9],
        [5.6, 4.3],
        [7.9, 2.3],
        [-1.0, 3.1]
    ])
    print("{:.4f}".format(diameter(m)))
