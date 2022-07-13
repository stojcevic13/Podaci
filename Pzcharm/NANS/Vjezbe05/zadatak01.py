import numpy as np
import matplotlib.pyplot as plt
import lagrangeInterpolation


if __name__ == '__main__':
    x = np.array([0.7854, 1.9635, 3.1416, 4.3197, 5.4978])
    fx = np.array([0.7071, 0.9239, 0.0000, -0.9239, -0.7071])

    plt.scatter(x, fx, c='black')

    p = lagrangeInterpolation.lagrange_interpolation(x, fx)
    x = np.linspace(np.min(x), np.max(x), 100)
    px = np.polyval(p, x)
    plt.plot(x, px, 'blue')

    plt.show()
