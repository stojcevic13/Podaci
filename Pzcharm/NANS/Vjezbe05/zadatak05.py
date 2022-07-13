import numpy as np
import matplotlib.pyplot as plt
import lagrangeInterpolation


if __name__ == '__main__':
    f = lambda x: x**2 * np.sin(x)
    a, b = -np.pi, np.pi
    x = np.linspace(a, b, 100)
    plt.plot(x, f(x))

    x4 = np.linspace(a, b, 4)
    plt.scatter(x4, f(x4), c='black')

    p = lagrangeInterpolation.lagrange_interpolation(x4, f(x4))
    px = np.polyval(p, x)
    plt.plot(x, px, 'red')

    print(np.round(p, 4))

    plt.show()
