import numpy as np


def fz1a(A, n):
    total_sum = 0
    elements, count = np.unique(A, return_counts=True)
    for i in range(len(elements)):
        if count[i] >= n:
            total_sum += elements[i]
    return total_sum


def fz2a(B):
    m, n = np.shape(B)
    middle = n // 2
    for i in range(n):
        m -= 1
        B[i, middle], B[i, m] = B[i, m], B[i, middle]
    return B


if __name__ == '__main__':
    A = [
        [6, 2, 3, 5],
        [5, 3, 9, 7],
        [2, 7, 9, 2],
        [2, 7, 5, 9]
    ]
    B = np.array([
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ])

    print(fz2a(B))
