import numpy as np
import matplotlib.pyplot as plt
import nans_lib_2 as lib


if __name__ == '__main__':

    # a)

    dnfx = lambda *args: 3 + np.cos(4/3*args[0]) - args[1]
    nfx0 = np.array([0, 1])
    a, b = 5, 20
    h = (b - a)/10000
    x = np.arange(a, b+h, h)
    fx, _ = lib.rk4N(a, b, h, nfx0, dnfx)

    p = lib.least_squares_regression(x, fx, 7)

    r = 15
    H = np.polyval(p, 20)
    V = r**2 * np.pi * H
    print('a) t=20s, Kolicina vode:{0:.4f}cm^3'.format(V))

    # b)

    nfx0 = np.array([5, 1])
    a, b = 10, 20
    h = (b - a)/10000
    x = np.arange(a, b+h, h)
    fx, _ = lib.rk4N(a, b, h, nfx0, dnfx)
    plt.plot(x, fx, 'red')

    p = lib.least_squares_regression(x, fx, 7)      # aproksimacija funkcije polinomom 7. stepena
    px = np.polyval(p, x)
    plt.plot(x, px, 'blue')

    p_diff = np.polyder(p)              # racunamo prvi izvod polinoma da bismo izracunali maksimalnu visinu
    l = lambda x: np.polyval(p_diff, x)

    x_max, _ = lib.zeroFalsePosition(l, 15, 17)     # u nuli prvog izvoda se nalazi maksimum funkcije
    y_max = np.polyval(p, x_max)
    plt.scatter(x_max, y_max, c='black')
    print('b) U trenutku {0:.4f}s maksimalna visina vode iznosi: {1:.4f}cm'.format(x_max, y_max))

    plt.show()
