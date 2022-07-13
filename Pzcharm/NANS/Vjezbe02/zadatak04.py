import numpy as np


if __name__ == '__main__':
    A = np.array([
        [-1., 2., -3.],
        [3., -4., -2.],
        [-4., -4., 4.],
    ])
    B = np.array(
        [10., 14., -15.]
    )
    C = np.array(
        [3., 3., 3.]
    )
    D = np.array(
    [-4., 0, 1.]
    )

    print(np.linalg.solve(A.T, D-B+2*C))
