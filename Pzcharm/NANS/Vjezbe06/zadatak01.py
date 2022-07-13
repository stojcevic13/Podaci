import numpy as np
import matplotlib.pyplot as plt
import leastsquares


if __name__ == '__main__':
    x = np.array([0, 1.25, 2.5, 3.75, 5])
    fx = np.array([1.7499, 0.983, 1.2554, 3.0802, 2.3664])
    plt.scatter(x, fx, c='black')

    p = leastsquares.least_squares_regression(x, fx, 3)
    x = np.linspace(0, 5, 100)
    px = np.polyval(p, x)
    plt.plot(x, px, 'blue')

    plt.show()
