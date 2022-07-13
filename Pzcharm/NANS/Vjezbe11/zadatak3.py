import numpy as np
import matplotlib.pyplot as plt
from nans_lib_2 import f, df, ddf, zeroFalsePosition, finiteDifference, least_squares_regression


if __name__ == '__main__':
    left = lambda *args: np.sin(2*args[0])**3 * ddf(args[1]) + df(args[1])
    right = lambda x: 3 - 2*x**2
    # x1, fx1 = 1, 0
    # x2, fx2 = 4, np.pi/2
    # h = (x2 - x1) / 100
    # x = np.arange(x1, x2+h, h)
    # fx = finiteDifference(left, right, x1, fx1, x2, fx2, h)
    # plt.plot(x, fx, 'blue')

    x1, fx1 = np.pi/4, 0
    x2, fx2 = np.pi, 1
    h = (x2 - x1) / 100
    x = np.arange(x1, x2+h, h)
    fx = finiteDifference(left, right, x1, fx1, x2, fx2, h)
    # plt.plot(x, fx, 'blue')

    p = least_squares_regression(x, fx, 7)
    px = np.polyval(p, x)
    plt.plot(x, px, 'red')
    func_b = lambda x: np.polyval(p, x) - 13

    plt.plot([x1, x2], [13, 13], 'gray')

    x01, _ = zeroFalsePosition(func_b, 1, 1.5)
    fx01 = np.polyval(p, x01)
    plt.scatter(x01, fx01, c='black')
    print(x01, fx01)
    x02, _ = zeroFalsePosition(func_b, 2.5, 3)
    fx02 = np.polyval(p, x02)
    print(x02, fx02)
    plt.scatter(x02, fx02, c='black')


    # pod c

    x03 = 2.3
    fx03 = np.polyval(p, x03)
    plt.scatter(x03, fx03, c='orange')
    print(x03, fx03)

    plt.show()
