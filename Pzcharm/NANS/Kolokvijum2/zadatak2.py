import numpy as np
import matplotlib.pyplot as plt
import nans_lib_2 as lib


if __name__ == '__main__':

    # a)

    left = lambda *args: -np.cos(args[0] - 2) * lib.ddf(args[1]) + lib.f(4/3*args[1])
    right = lambda x: np.log(5/4*x) - np.sin(13)
    x0, fx0 = 1, 137
    xN, fxN = 5, 432
    h = (xN - x0) / 100
    x = np.arange(x0, xN + h, h)
    fx = lib.finiteDifference(left, right, x0, fx0, xN, fxN, h)

    p = lib.least_squares_regression(x, fx, 7)
    px = np.polyval(p, x)
    plt.plot(x, fx, c='red')
    plt.plot(x, px, 'blue')

    # b)

    D = 4
    pD = np.polyval(p, D)

    V = np.cos(pD)/3 * pD**3 * np.sin(D+2)
    print('b) Promet za petak iznosi: {0:.4f}'.format(V))

    # c)

    val = 700
    f = lambda x: np.polyval(p, x) - val
    plt.plot([x0, xN], [val, val], 'gray')
    x1, _ = lib.zeroFalsePosition(f, 3.5, 4)
    x2, _ = lib.zeroFalsePosition(f, 4.3, 4.8)
    plt.scatter(x1, val, c='green')
    plt.scatter(x2, val, c='green')
    print('c) Cijena je dostigla 700$ u momentima: {0:.4f} i {1:.4f}'.format(x1, x2))

    plt.show()
