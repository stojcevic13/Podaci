import numpy as np
from integrate_simpson import integrate_simpson

if __name__ == '__main__':
    c = 2/np.sqrt(2*np.pi)
    f = lambda x: np.exp(-x**2/2)
    I = integrate_simpson(f, 0, 0.2, 100, 100)
    print(I * c)
