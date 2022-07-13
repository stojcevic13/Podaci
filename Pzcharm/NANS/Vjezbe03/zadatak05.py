import numpy as np
from jacobi import jacobi

if __name__ == '__main__':
    A = np.array([
        [4, 2, 0],
        [1, 2, 0],
        [2, 1, 4]
    ])
    b = np.array([1, -1, 0])
    x0 = np.array([1, 2, 3])

    solution = jacobi(A, b, x0)
    solution[2] = 1/solution[2]
    print(solution)
