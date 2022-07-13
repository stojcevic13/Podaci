import numpy as np


def sort_by_first_column(matrix):
    rows, cols = np.shape(matrix)
    for i in range(rows-1):
        for j in range(i+1, rows):
            if matrix[i][0] < matrix[j][0]:
                tmp = np.array([matrix[i, 0], matrix[i, 1]])
                matrix[i] = matrix[j]
                matrix[j] = tmp
                # matrix[i], matrix[j] = matrix[j], matrix[i]
    return matrix


if __name__ == '__main__':
    m = np.array([
        [66, 1],
        [100, 2],
        [133, 3],
        [200, 4],
        [33, 5],
        [66, 6],
        [133, 7],
        [266, 8]
    ])
    print(sort_by_first_column(m))
