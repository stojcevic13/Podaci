import numpy as np


if __name__ == '__main__':
    x1, y1, z1 = 2088.202, -11757.191, 25391.472
    x2, y2, z2 = 11092.568, -14198.201, 21471.166
    x3, y3, z3 = 35606.98, 94447.03, 9101.38
    x4, y4, z4 = 3966.929, 7362.852, 26388.447
    r1, r2, r3, r4 = 23204.699, 21585.835, 31364.260, 24966.799

    A = np.array([
        [2*(x2-x1), 2*(y2-y1), 2*(z2-z1)],
        [2*(x3-x1), 2*(y3-y1), 2*(z3-z1)],
        [2 * (x4 - x1), 2 * (y4 - y1), 2 * (z4 - z1)]
    ])
    b = np.array([

    ])
