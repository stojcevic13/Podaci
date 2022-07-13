import numpy as np
import matplotlib.pyplot as plt
import zero_newton
import zero_secant

if __name__ == '__main__':
    f = np.cos
    df = np.sin
    a, b = np.pi/3, 4*np.pi/3
    x = np.linspace(a, b, 100)
    plt.plot(x, f(x), 'blue')
    plt.plot([a, b], [0, 0], 'black')

    zero, it = zero_secant.zero_secant(f, a, 2, 0.0001, 100, 0.0)
    print(zero, f(zero))
    plt.scatter(zero, f(zero), c='r')
    plt.show()
