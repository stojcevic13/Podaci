import numpy as np
from jacobi import jacobi


if __name__ == '__main__':
    A = np.array([
        [9, 3, 1],
        [7, 8, 9],
        [4, 1, 9]
    ])
    b = np.array([33, 54, 13])
    x0 = np.array([1, 2, 3])
    
    print(jacobi(A, b, x0))
