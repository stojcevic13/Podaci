import numpy as np
from integrate_simpson import integrate_simpson

if __name__ == '__main__':
    f = lambda x: x**2
    g = lambda x: np.sqrt(x)
    a, b = 0, 2
    h = lambda x: np.abs(f(x) - g(x))
    I = integrate_simpson(h, a, b, 100, 0)
    print(I)
