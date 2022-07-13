import numpy as np


def sum_grater(matrix):
    average = np.average(matrix)
    mask = (matrix > average)
    grater_sum = np.sum(matrix[mask])
    return grater_sum


if __name__ == '__main__':
    m = np.array([
        [2, 1, 2, 6, 8, 1, -2],
        [15, 4, 7, 18, 4, 0, 12],
        [11, 6, 9, -1, 4, 8, 0],
        [2, 8, 6, 8, 1, 8, 7]
    ])
    print(sum_grater(m))
