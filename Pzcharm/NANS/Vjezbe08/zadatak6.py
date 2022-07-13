import numpy as np
from integrate_simpson import integrate_simpson


if __name__ == '__main__':
    f = lambda x: np.sqrt(x - 2)
    P = integrate_simpson(f, 2, 4, 100, 0)
    print(P)
