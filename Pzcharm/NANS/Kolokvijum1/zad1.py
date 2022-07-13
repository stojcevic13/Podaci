import numpy as np
import NANS_lib


if __name__ == '__main__':
    x = 0.1
    x2 = 1.2
    A = np.array([
        [1, x, x**2, x**3],
        [1, 3*x, (3*x)**2, (3*x)**3],
        [1, (x2/3 + 2*x), (x2/3 + 2*x)**2, (x2/3 + 2*x)**3],
        [1, x2, x2**2, x2**3]
    ])
    b = np.array([1.023, 0.061 + x2, 2*x2 - 0.032, 9.064])
    print(NANS_lib.gauss_seidel(A, b, [0, 0, 0, 0]))
