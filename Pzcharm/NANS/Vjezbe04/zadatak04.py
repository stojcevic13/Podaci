import numpy as np
import matplotlib.pyplot as plt
import zero_false_position


if __name__ == '__main__':
    f = lambda x: x**2 - x + 3
    g = lambda x: np.exp(x)
    a, b = 0, 2

    f_diff = lambda x: f(x) - g(x)

    x = np.linspace(a, b, 100)
    plt.plot(x, f(x), 'blue')
    plt.plot(x, g(x), 'red')
    plt.plot([a, b], [0, 0], 'black')

    zero, _ = zero_false_position.zero_false_position(f_diff, a, b)
    plt.scatter(zero, f(zero), c='y')

    plt.show()
