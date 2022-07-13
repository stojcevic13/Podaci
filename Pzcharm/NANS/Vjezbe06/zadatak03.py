import numpy as np
import matplotlib.pyplot as plt
import leastsquares
import zero_false_position


if __name__ == '__main__':
    f = lambda x: x**2 * np.sin(x)
    a, b = -np.pi, np.pi
    x = np.linspace(a, b, 100)
    plt.plot(x, f(x))

    # x = np.linspace(a, b, 4)
    p = leastsquares.least_squares_regression(x, f(x), 3)
    px = np.polyval(p, x)
    plt.plot(x, px, 'red')

    h = lambda x: f(x) - np.polyval(p, x)
    x1, _ = zero_false_position.zero_false_position(h, -0.5, 0.5)
    plt.scatter(x1, f(x1), c='green')

    print(f'x1 = {x1}')
    plt.show()
