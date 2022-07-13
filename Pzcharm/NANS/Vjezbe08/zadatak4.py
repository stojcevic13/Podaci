import numpy as np
from integrate_simpson import integrate_simpson


if __name__ == '__main__':
    f = lambda x: (np.exp(2*x) / x)**2
    V = np.pi * integrate_simpson(f, 1, 2, 100, 0)
    print(V)
