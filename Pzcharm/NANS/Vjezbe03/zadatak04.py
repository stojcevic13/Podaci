import numpy as np
from jacobi import jacobi

if __name__ == '__main__':
    A = np.array([
        [2, 1],
        [1, 2],
    ])
    b = np.array([1, -2])
    x0 = np.array([1, 2])

    solution = jacobi(A, b, x0)
    solution[1] = 1/solution[1]
    print(solution)
