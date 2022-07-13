import numpy as np


def get_sum_vector(matrix):
    rows, cols = np.shape(matrix)
    b = []
    for row in range(rows):
        row_sum = 0
        for col in range(cols):
            if row + col != rows-1:
                row_sum += matrix[row, col]
        b.append(row_sum)
    return np.array(b)


if __name__ == '__main__':
    m = np.array([
        [-0.5, 10, 2],
        [-1, 1, 0],
        [1, -6, -3]
    ])
    print(get_sum_vector(m))
