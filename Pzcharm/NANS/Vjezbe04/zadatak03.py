import numpy as np
import matplotlib.pyplot as plt
import zero_false_position


if __name__ == '__main__':
    f = lambda x: np.sin(2*x)
    a, b = np.pi/4, 7*np.pi/4
    x = np.linspace(a, b, 100)

    plt.plot(x, f(x), 'blue')
    plt.plot([a, b], [0, 0], 'black')

    zero, _ = zero_false_position.zero_false_position(f, 1, 2)
    plt.scatter(zero, f(zero), c='r')
    zero, _ = zero_false_position.zero_false_position(f, 3, 4)
    plt.scatter(zero, f(zero), c='r')
    zero, _ = zero_false_position.zero_false_position(f, 4, 5)
    plt.scatter(zero, f(zero), c='r')

    plt.show()
