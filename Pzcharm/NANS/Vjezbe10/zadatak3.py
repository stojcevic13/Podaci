import numpy as np
import matplotlib.pyplot as plt
from ddf import ddf
from df import df
from finiteDifference import finiteDifference


if __name__ == '__main__':
    left = lambda *args: 2*args[0]**2*ddf(args[1]) - 4*df(args[1]) + np.sin(args[0])*args[1]
    right = lambda x: np.sqrt(x)
    x1, fx1 = 0, 0
    x2, fx2 = 2, 1
    h = (x2 - x1) / 100
    x = np.arange(x1, x2 + h, h)
    fx = finiteDifference(left, right, x1, fx1, x2, fx2, h)
    plt.plot(x, fx)
    plt.show()
