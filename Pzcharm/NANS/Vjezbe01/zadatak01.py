import numpy as np


def sum_d(matrix):
    x, y = matrix.shape
    if x != y:
        raise Exception("Greska!")

    total_sum = 0
    for i in range(x):
        total_sum += matrix[i, i]

    # VEKTORSKI #1
    total_sum = np.sum(np.diagonal(matrix))

    # VEKTORSKI #2
    I = np.identity(x)
    sum_matrix = matrix * I
    total_sum = np.sum(np.diagonal(sum_matrix))

    # VEKTORSKI #3
    mask = np.identity(x).astype(bool)
    total_sum = sum(matrix[mask])

    return total_sum


if __name__ == '__main__':
    m = np.array([[2, 1, 6, 1], [1, 3, 8, 2], [5, 9, 4, 3], [1, 1, 8, 5]])
    print(sum_d(m))

    print(np.identity(3))
