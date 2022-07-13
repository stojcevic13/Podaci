import numpy as np
import matplotlib.pyplot as plt
from ddf import ddf
from df import df
from f import f
from finiteDifference import finiteDifference
from lSquares import lSquares


if __name__ == '__main__':
    left = lambda *args: -2*ddf(args[1]) + df(args[1]) + f(args[1])/2
    right = lambda x: np.sin(x) / (x+1)
    x1, fx1 = 0, 0
    x2, fx2 = 10, 3.5
    h = (x2 - x1)/100
    x = np.arange(x1, x2 + h, h)
    fx = finiteDifference(left, right, x1, fx1, x2, fx2, h)

    p = lSquares(x, fx, 7)
    px = np.polyval(p, x)
    plt.plot(x, px, 'red')
    plt.plot(x, fx, 'blue')

    px5 = np.polyval(p, 5)
    plt.scatter(5, px5, c='black')
    print(px5)
    plt.show()
