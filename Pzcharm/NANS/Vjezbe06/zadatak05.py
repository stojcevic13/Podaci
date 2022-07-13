import numpy as np
import matplotlib.pyplot as plt
import leastsquares
import zero_false_position


if __name__ == '__main__':
    f = lambda x: x**3 * np.cos(x)
    a, b = -np.pi/2, 5*np.pi/9
    x = np.linspace(a, b, 100)

    p = leastsquares.least_squares_regression(x, f(x), 5)
    px = np.polyval(p, x)
    plt.plot(x, px)

    g = lambda x: f(x) + 0.5
    x1, _ = zero_false_position.zero_false_position(g, -1.5, -1)
    plt.scatter(x1, f(x1), c='green')
    x2, _ = zero_false_position.zero_false_position(g, -1, -0.5)
    plt.scatter(x2, f(x2), c='green')
    x3, _ = zero_false_position.zero_false_position(g, 1.5, 2)
    plt.scatter(x3, f(x3), c='green')

    print(x1)
    print(x2)
    print(x3)

    plt.show()
