import numpy as np


def fz4a(A, B):
    m, n = np.shape(A)
    k = np.shape(B)[0]

    C = np.array([[0] * (n - k + 1)] * (m - k + 1), 'd')
    for row in range(m - k + 1):    # row = 0
        for col in range(n - k + 1):       # col = 1
            M = A[row:row + k, col:col + k]
            p = 0
            for i in range(k):
                for j in range(k):
                    p += B[i, j] * M[i, j]
            C[row, col] = p
    return C


def fz4b(A):
    m, n = A.shape
    for i in range(m):
        for j in range(n):
            if j+2 < n and A[i, j] == A[i, j+1] == A[i, j+2]:   # desno
                return True
            if i+2 < m and A[i, j] == A[i+1, j] == A[i+2, j]:   # dole
                return True
            if i+2 < m and j+2 < n and A[i, j] == A[i+1, j+1] == A[i+2, j+2]:   # \ glavne
                return True
            if i+2 < m and j-2 >= 0 and A[i, j] == A[i+1, j-1] == A[i+2, j-2]:   # / sporedne
                return True
    return False


if __name__ == '__main__':
    A = np.array([
        [1, 2, 3, 1, 1],
        [0, 3, 0, 1, 3],
        [0, 3, 0, 1, 4],
        [0, 3, 2, 1, 2],
        [4, 1, 2, 1, 4]
    ])
    B = np.array([
        [0, 3, 1],
        [0, 2, 2],
        [2, 1, 1]
    ])

    print(fz4a(A, B))
    print(fz4b(A))
