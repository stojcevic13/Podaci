import numpy as np
import matplotlib.pyplot as plt
import nans_lib_2
import integrate_simpson


if __name__ == '__main__':
    f = lambda x: np.sqrt(1 - (np.abs(x) - 1)**2) + np.pi
    g = lambda x: np.arccos(1 - np.abs(x))

    a, b = -2, 2
    x = np.linspace(a, b, 1000)
    fx = f(x)
    gx = g(x)

    plt.plot(x, fx, 'blue')
    plt.plot(x, gx, 'red')


    # pod b

    h = lambda x: 0.4*x + 2
    hx = h(x)
    plt.plot(x, hx, 'black')


    # pod c

    # trazimo tacke presjeka g i h:
    tmp1 = lambda x: h(x) - g(x)
    # tmp2 = lambda x: f(x) - h(x)
    x1, _ = nans_lib_2.zeroFalsePosition(tmp1, -1.5, -0.5)
    x2, _ = nans_lib_2.zeroFalsePosition(tmp1, 1, 2)
    y1, y2 = h(x1), h(x2)
    plt.scatter(x1, y1, c='black')
    plt.scatter(x2, y2, c='black')

    p1 = integrate_simpson.integrate_simpson(tmp1, x1, x2, 100, 100)

    plt.show()
