import numpy as np
import matplotlib.pyplot as plt
from ddf import ddf
from df import df
from finiteDifference import finiteDifference
from zeroFalsePosition import zeroFalsePosition
from lSquares import lSquares


if __name__ == '__main__':
    left = lambda *args: np.cos(args[0])**2 * ddf(args[1]) - df(args[1])
    right = lambda x: 0
    x1, fx1 = 0, 0
    x2, fx2 = np.pi, 1
    h = (x2 - x1)/100
    x = np.arange(x1, x2 + h, h)
    fx = finiteDifference(left, right, x1, fx1, x2, fx2, h)

    p = lSquares(x, fx, 7)      # koeficijenti
    px = np.polyval(p, x)       # vrijednosti funkcije
    func = lambda x: np.polyval(p, x) - 1

    x1, a = zeroFalsePosition(func, 0, 1.5)
    x2, a = zeroFalsePosition(func, 1.5, 2)
    x3, a = zeroFalsePosition(func, 2, 2.5)
    x4, a = zeroFalsePosition(func, 2.5, 3)

    print(x1)
    print(x2)
    print(x3)
    print(x4)

    plt.plot(x, fx, 'blue')
    plt.plot(x, px, 'red')
    plt.show()
