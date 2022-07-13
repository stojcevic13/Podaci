import numpy as np
import matplotlib.pyplot as plt
from rk4N import rk4N


if __name__ == '__main__':
    dnfx = lambda *argv: -36*argv[1] - 13*argv[3]
    nfx0 = np.array([0, -3, 5, -3])
    a, b = 0, 4*np.pi
    h = (b - a) / 10000
    x = np.arange(a, b, h)
    fx_rk4, _ = rk4N(a, b, h, nfx0, dnfx, 0.0)
    plt.plot(x, fx_rk4, 'red')
    plt.show()
