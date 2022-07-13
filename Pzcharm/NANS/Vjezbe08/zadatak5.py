import numpy as np
from integrate_simpson import integrate_simpson


if __name__ == '__main__':
    f = lambda x: np.exp(x) + 2
    g = lambda x: np.sqrt(x)
    h = lambda x: f(x)**2 - g(x)**2

    # Vf = np.pi * integrate_simpson(f, 2, 3, 1000, 0)
    # Vg = np.pi * integrate_simpson(g, 2, 3, 1000, 0)
    V = np.pi * integrate_simpson(h, 2, 3, 1000, 0)
    print(V)
