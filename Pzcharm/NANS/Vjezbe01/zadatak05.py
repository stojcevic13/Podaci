import numpy as np


def min_diagonal_vector(matrix):
    n = np.shape(matrix)[0]
    min_elem, x, y = matrix[0, 0], 0, 0
    for i in range(n):
        if matrix[i, i] < min_elem:
            min_elem, x, y = matrix[i, i], i, i

    row, col = n-1, 0
    while row != -1:
        if matrix[row, col] < min_elem:
            min_elem, x, y = matrix[row, col], row, col
        row, col = row-1, col+1

    # for row, col in zip(range(n-1, -1, -1), range(n)):
    #     if matrix[row, col] < min_elem:
    #         min_elem, x, y = matrix[row, col], row, col

    return np.array([x, y])


if __name__ == '__main__':
    m = np.array([
        [-2, 5, -7],
        [-1, -1, -8],
        [-3, -5, 1]
    ])

    print(min_diagonal_vector(m))
