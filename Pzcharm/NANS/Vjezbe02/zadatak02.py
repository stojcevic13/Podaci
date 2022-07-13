import numpy as np
from gauss import gauss_vect

if __name__ == '__main__':
    A = np.array([
        [3., 4., 1.],
        [1., 0, 1.],
        [2., 3., 2.]
    ])
    b = np.array([3., 3., 1.5])
    print(gauss_vect(A, b))
    # print(np.linalg.solve(A, b))
