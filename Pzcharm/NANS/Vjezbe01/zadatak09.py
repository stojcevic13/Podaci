import numpy as np


def rotate_col(matrix, rows, col):
    start, end = 0, rows-1
    while start < end:
        matrix[start, col], matrix[end, col] = matrix[end, col], matrix[start, col]
        start += 1
        end -= 1


def rotate_odd_cols(matrix):
    rows, cols = np.shape(matrix)
    for col in range(cols):
        if col % 2 == 0:
            rotate_col(matrix, rows, col)


if __name__ == '__main__':
    m = np.array([
        [0.3, 1, -5],
        [-1, 4, 0],
        [1, 5, 2]
    ])
    rotate_odd_cols(m)
    print(m)
