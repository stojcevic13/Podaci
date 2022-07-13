import numpy as np
import matplotlib.pyplot as plt
import leastsquares
import zero_false_position
import sympy as sym


if __name__ == '__main__':
    x = np.array([0, 1, 2, 3, 4, 5])
    fx = np.array([5, 3, 5, 1, 3, 5])
    plt.scatter(x, fx, c='black')

    p = leastsquares.least_squares_regression(x, fx, 5)
    x = np.linspace(0, 5, 100)
    px = np.polyval(p, x)
    plt.plot(x, px, 'blue')

    p_diff = np.polyder(p)
    h = lambda x: np.polyval(p_diff, x)

    min, _ = zero_false_position.zero_false_position(h, 3, 4)
    plt.scatter(min, np.polyval(p, min), c='green')
    max, _ = zero_false_position.zero_false_position(h, 4, 5)
    plt.scatter(max, np.polyval(p, max), c='green')

    print(f'xmin = {min}')
    print(f'xmax = {max}')

    plt.show()
