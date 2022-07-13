import numpy as np
from jacobi import jacobi

if __name__ == '__main__':
    A = np.array([
        [4, 1, 2],
        [1, 2, 0],
        [-1, -1, 3]
    ])
    b = np.array([1, 2, 3])
    x0 = [0, 0, 0]

    print(jacobi(np.sin(A), b, x0))
