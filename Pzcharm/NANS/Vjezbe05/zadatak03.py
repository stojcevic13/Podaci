import numpy as np
import matplotlib.pyplot as plt
import lagrangeInterpolation
import zero_false_position


if __name__ == '__main__':
    x = np.array([1, 4, 5])
    fx = np.array([1, 3, 3])

    plt.scatter(x, fx, c='black')

    p = lagrangeInterpolation.lagrange_interpolation(x, fx)
    x = np.linspace(np.min(x), np.max(x), 100)
    px = np.polyval(p, x)
    plt.plot(x, px)

    f = lambda x: np.polyval(p, x) - 2
    x1, _ = zero_false_position.zero_false_position(f, 1, 5)
    plt.scatter(x1, 2, c='green')

    plt.show()
