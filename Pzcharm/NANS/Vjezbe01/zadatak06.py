import numpy as np


def rotate_row(matrix, row, cols):
    start, end = 0, cols-1
    while start < end:
        matrix[row, start], matrix[row, end] = matrix[row, end], matrix[row, start]
        start += 1
        end -= 1


def rotate_odd_rows(matrix):
    rows, cols = np.shape(matrix)
    for row in range(rows):
        if row % 2 == 0:
            rotate_row(matrix, row, cols)
    return matrix


if __name__ == '__main__':
    m = np.array([
        [0.3, 1, -5],
        [-1, 4, 0],
        [1, 5, 2]
    ])
    rotate_odd_rows(m)
    print(m)
