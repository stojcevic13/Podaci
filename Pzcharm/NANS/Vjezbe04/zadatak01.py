import numpy as np
import matplotlib.pyplot as plt
import zero_false_position

if __name__ == '__main__':
    f = np.sin
    a, b = np.pi/3, 4*np.pi/3
    x = np.linspace(a, b, 100)
    fx = f(x)
    plt.plot(x, fx, 'blue')
    plt.plot([a, b], [0, 0], 'black')

    zero, it = zero_false_position.zero_false_position(f, a, b)
    plt.scatter(zero, f(zero), c='r')
    plt.show()
