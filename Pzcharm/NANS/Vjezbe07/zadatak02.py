import numpy as np
import nans_lib_1


if __name__ == '__main__':
    A = np.array([
        [1, -2, 1, -8],
        [3, -9, 27, -12],
        [4, -12, 64, -12],
        [2, -2, 8, -4]
    ])
    b = np.array([11.5, 7.8, 9.9, 5])
    print(nans_lib_1.gauss(A, b))
