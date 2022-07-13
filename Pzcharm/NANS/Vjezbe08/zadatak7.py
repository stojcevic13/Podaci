import numpy as np
from integrate_simpson import integrate_simpson


if __name__ == '__main__':
    f = lambda x: x**2 + 2
    H = f(4)
    r = 4
    Vv = r**2*np.pi * H

    f_1 = lambda x: np.sqrt(x - 2) ** 2
    Vm = np.pi * integrate_simpson(f_1, f(0), f(4), 1000, 0)
    print(Vv - Vm)
