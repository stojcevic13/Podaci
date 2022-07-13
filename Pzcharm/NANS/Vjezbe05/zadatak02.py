import numpy as np
import matplotlib.pyplot as plt
import lagrangeInterpolation


if __name__ == '__main__':
    x = np.array([1, 2, 4])
    fx = np.array([4, 5, 4])

    plt.scatter(x, fx, c='black')

    p = lagrangeInterpolation.lagrange_interpolation(x, fx)
    x = np.linspace(np.min(x), np.max(x), 100)
    px = np.polyval(p, x)
    plt.plot(x, px)

    new_x = 3
    new_px = np.polyval(p, new_x)
    plt.scatter(new_x, new_px, c='green')

    plt.show()
