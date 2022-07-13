import numpy as np
import matplotlib.pyplot as plt
from ddf import ddf
from df import df
from f import f
from finiteDifference import finiteDifference


if __name__ == '__main__':
    left = lambda *args: ddf(args[1]) + 2*df(args[1]) + f(args[1])
    right = lambda x: x**2
    x1, fx1 = 0, 0.2
    x2, fx2 = 1, 0.8
    h = (x2 - x1)/1000
    x = np.arange(x1, x2+h, h)
    fx = finiteDifference(left, right, x1, fx1, x2, fx2, h)
    plt.plot(x, fx)
    plt.show()
