import numpy as np
import matplotlib.pyplot as plt
import lagrangeInterpolation
import zero_false_position


if __name__ == '__main__':
    x = np.array([1, 3, 5])
    fx = np.array([0, 3, 0])
    plt.scatter(x, fx, c='black')

    p = lagrangeInterpolation.lagrange_interpolation(x, fx)
    x = np.linspace(np.min(x), np.max(x))
    px = np.polyval(p, x)
    plt.plot(x, px)

    plt.plot([np.min(x), np.max(x)], [1, 1], 'red')

    h = lambda x: np.polyval(p, x) - 1
    x1, _ = zero_false_position.zero_false_position(h, 1, 3)
    print(x1)
    plt.scatter(x1, 1, c='green')
    x2, _ = zero_false_position.zero_false_position(h, 3, 5)
    print(x2)
    plt.scatter(x2, 1, c='green')

    plt.show()
