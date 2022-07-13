import numpy as np
import jacobi


if __name__ == '__main__':
    A = np.array([
        [4, 2, 0],
        [1, 2, 0],
        [2, 1, 4]
    ])
    b = np.array([1, -1, 0])
    x = jacobi.jacobi(A, b, [5, 5, 5])
    x[2] = 1 / x[2]
    print(x)
