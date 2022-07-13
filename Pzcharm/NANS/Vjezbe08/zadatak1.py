import numpy as np
import matplotlib.pyplot as plt
from integrate_simpson import integrate_simpson


if __name__ == '__main__':
    f = lambda x: np.sin(x)
    a = 0
    b = 3*np.pi / 2
    I = integrate_simpson(f, a, b, 100, 100)
    print(I)
