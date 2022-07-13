import numpy as np
import matplotlib.pyplot as plt
import zero_false_position


if __name__ == '__main__':
    f = lambda x: x**2 - 2
    g = lambda x: -x**2 + 2
    a, b = -2, 2

    x = np.linspace(a, b, 100)
    plt.plot(x, f(x), 'blue')
    plt.plot(x, g(x), 'red')

    f_dif = lambda x: f(x) - g(x)

    zero, _ = zero_false_position.zero_false_position(f_dif, a, 0)
    plt.scatter(zero, f(zero), c='y')
    zero, _ = zero_false_position.zero_false_position(f_dif, 0, b)
    plt.scatter(zero, f(zero), c='y')

    plt.show()
