import numpy as np


def vector_min(matrix):
    n, m = np.shape(matrix)  # n=row, m=col
    b = []
    for col in range(m):
        min_elem, min_index = matrix[0, col], 0
        for row in range(n):
            if matrix[row, col] < min_elem:
                min_elem = matrix[row, col]
                min_index = row
        b.append(min_index)
    return np.array(b)


if __name__ == '__main__':
    mm = np.array([
        [-2, 5, -3],
        [-1, -1, 0],
        [-3, -5, 1]
    ])
    print(vector_min(mm))
