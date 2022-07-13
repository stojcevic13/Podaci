import numpy as np
import matplotlib.pyplot as plt
import leastsquares


if __name__ == '__main__':
    x = np.array([1, 2, 3, 5, 6])
    fx = np.array([2, 4, 4, 1, 3])
    plt.scatter(x, fx, c='black')

    p = leastsquares.least_squares_regression(x, fx, 4)
    x = np.linspace(1, 6, 100)
    px = np.polyval(p, x)
    plt.plot(x, px, 'blue')

    x4 = 4
    fx4 = np.polyval(p, x4)
    plt.scatter(x4, fx4, c='red')
    print(f'f(4) = {fx4}')

    plt.show()
