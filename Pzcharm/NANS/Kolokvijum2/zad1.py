import numpy as np
import matplotlib.pyplot as plt
import nans_lib_2 as lib


if __name__ == '__main__':
    left = lambda *args: np.cos(np.sin(3*args[0])) * lib.df(args[1]) - np.log(12)*lib.ddf(args[1]) + 4*lib.f(4*args[1])/3
    right = lambda x: -np.exp(x) + 2*x
    x0, fx0 = 3, 4/3
    xN, fxN = 6, 2*np.pi
    h = (xN - x0) / 1000
    x = np.arange(x0, xN + h, h)
    fx = lib.finiteDifference(left, right, x0, fx0, xN, fxN, h)
    print(fx)
    # plt.plot(x, fx, 'blue')

    p = lib.least_squares_regression(x, fx, 7)
    px = np.polyval(p, x)
    plt.plot(x, px, 'red')

    func_b = lambda x: np.polyval(p, x) + 12.5

    x01, _ = lib.zeroFalsePosition(func_b, 3, 4)
    fx01 = np.polyval(p, x01)
    x02, _ = lib.zeroFalsePosition(func_b, 5.5, 6)
    fx02 = np.polyval(p, x02)

    plt.scatter(x01, fx01, c='black')
    plt.scatter(x02, fx02, c='black')
    print(x01, fx01)
    print(x02, fx02)

    x03 = 4.75
    fx03 = np.polyval(p, x03)
    plt.scatter(x03, fx03, c='green')
    print(x03, fx03)

    plt.show()

