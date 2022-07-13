import numpy as np
import matplotlib.pyplot as plt
from rk4N import rk4N

if __name__ == '__main__':
    dnfx = lambda *argv: -argv[1] + argv[0] + 2
    nfx0 = np.array([4, 2])
    a, b = 0, 4*np.pi
    h = (b - a) / 10000
    x = np.arange(a, b, h)
    fx_rk4, sss = rk4N(a, b, h, nfx0, dnfx, 0.0)

    plt.plot(x, fx_rk4, 'red')
    plt.show()
