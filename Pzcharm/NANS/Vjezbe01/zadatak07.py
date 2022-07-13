import numpy as np


def max_row_vector(matrix):
    rows, cols = np.shape(matrix)
    b = []
    for row in range(rows):
        max_elem, max_col = matrix[row, 0], 0
        for col in range(cols):
            if matrix[row, col] > max_elem:
                max_elem, max_col = matrix[row, col], col
        b.append(max_col)
    return np.array(b)


if __name__ == '__main__':
    m = np.array([
        [-2, 5, 3],
        [-1, -1, 0],
        [-1, -5, -3]
    ])
    print(max_row_vector(m))
