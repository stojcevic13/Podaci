import numpy as np
import matplotlib.pyplot as plt
import nans_lib_2


if __name__ == '__main__':
    f = lambda x: 2*x**2 + 2
    g = lambda x: 20*np.cos(x)
    h = lambda x: np.abs(f(x) - g(x))

    P = nans_lib_2.integrate_simpson(h, 0, 2.5, 100)
    print(f'a) P={P}')

    f_1 = lambda x: np.sqrt((x-2)/2)**2

    x = np.linspace(0, 2, 100)
    plt.plot(x, f(x))
    plt.plot([0, 2], [0, 0], 'black')
    plt.show()

    r, H = 2, 10
    Vv = r**2*np.pi*H
    Vm = np.pi * nans_lib_2.integrate_simpson(f_1, 2, 10, 100)
    V = Vv - Vm
    print(V)
