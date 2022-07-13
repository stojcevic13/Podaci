import numpy as np
import NANS_lib


if __name__ == '__main__':
    x1, x2 = 0.5, 1.7  # iz uslova datih u zadatku
    t1, t2, t3, t4 = x1, 4 * x1 - 2 * x2, 2 * x1, x2

    A = np.array([
        [1, t1, t1**2, t1**3],
        [1, t2, t2**2, t2**3],
        [1, t3, t3**2, t3**3],
        [1, t4, t4**2, t4**3]
    ])
    b = np.array([5.625, -0.512, x2 + 14.3, 44.469])

    a = NANS_lib.gauss(A, b)

    f = np.sqrt(a[0]) - 2 / 5 * a[1] - a[2] + a[3] ** 2
    print(f'sqrt(a0) - 2/5*a1 - a2 + a3^2 = {np.round(f)}')
