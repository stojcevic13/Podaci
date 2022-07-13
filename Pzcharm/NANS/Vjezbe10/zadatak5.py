import numpy as np
import matplotlib.pyplot as plt
from ddf import ddf
from df import df
from finiteDifference import finiteDifference
from lSquares import lSquares


if __name__ == '__main__':
    left = lambda *args: -2*ddf(args[1])
    right = lambda x: 2 - x**3
    x1, fx1 = 2, 2
    x2, fx2 = 4, -2
    h = (x2 - x1)/100
    x = np.arange(x1, x2 + h, h)
    fx = finiteDifference(left, right, x1, fx1, x2, fx2, h)

    p = lSquares(x, fx, 7)
    px = np.polyval(p, x)
    p3 = np.polyval(p, 3)

    plt.plot(x, fx, 'blue')
    plt.plot(x, px, 'red')
    plt.scatter(3, p3)
    print(p3)

    plt.show()
