import numpy as np
import matplotlib.pyplot as plt
import nans_lib_2


if __name__ == '__main__':
    dnfx = lambda *argv: -argv[1] + np.cos(3*argv[0]) + 1
    # nfx0 = np.array([1, 0])
    # a, b = 0, 4*np.pi
    # h = (b - a) / 10000
    # x = np.arange(a, b + h, h)
    # fx_rk4, sss = nans_lib_2.rk4N(a, b, h, nfx0, dnfx)

    # plt.plot(x, fx_rk4, 'blue')

    # pod b
    nfx0 = np.array([0, 1])
    a, b = 0, 2 * np.pi
    h = (b - a) / 1000
    x = np.arange(a, b + h, h)
    fx_rk4, _ = nans_lib_2.rk4N(a, b, h, nfx0, dnfx)
    plt.plot(x, fx_rk4, 'red')

    p = nans_lib_2.least_squares_regression(x, fx_rk4, 7)
    px = np.polyval(p, x)
    func_b = lambda x: np.polyval(p, x) - 1.5

    x1, a = nans_lib_2.zeroFalsePosition(func_b, 1, 3)
    x2, a = nans_lib_2.zeroFalsePosition(func_b, 6, 8)
    print(x1, x2)

    plt.plot(x, px, 'black')

    # pod c

    x3 = 2.6
    px3 = np.polyval(p, x3)
    print(x3, px3)
    plt.scatter(x3, px3, c='orange')


    plt.show()