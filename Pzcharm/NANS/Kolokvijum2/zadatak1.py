import numpy as np
import matplotlib.pyplot as plt
import nans_lib_2


if __name__ == '__main__':

    # a)

    f = lambda x: np.sqrt(1 - (np.abs(x) - 1)**2) + np.pi
    g = lambda x: np.arccos(1 - np.abs(x))

    a, b = -2, 2
    x = np.linspace(a, b, 1000)

    plt.plot(x, f(x), 'red')
    plt.plot(x, g(x), 'red')

    # b)

    h = lambda x: x + 2
    hx = h(x)
    plt.plot(x, hx, 'black')

    # c)

    # trazimo tacke presjeka funkcija g i h:
    g_h = lambda x: g(x) - h(x)
    f_h = lambda x: f(x) - h(x)
    x1, _ = nans_lib_2.zeroFalsePosition(g_h, -1, -0.5)
    x2, _ = nans_lib_2.zeroFalsePosition(f_h, 1.5, 2)

    f_g = lambda x: f(x) - g(x)
    h_g = lambda x: h(x) - g(x)

    p1_1 = nans_lib_2.integrate_simpson(f_h, x1, x2, 100)       # povrsina izmedju funkcija f i h
    p1_2 = nans_lib_2.integrate_simpson(f_g, -2, x1, 100)       # povrsina izmedju funkcija f i g
    p1 = p1_1 + p1_2
    print('c) p1={0:.4f}'.format(p1), end='   ')

    p2_1 = nans_lib_2.integrate_simpson(h_g, x1, x2, 100)       # povrsina izmedju funkcija h i g
    p2_2 = nans_lib_2.integrate_simpson(f_g, x2, 2, 100)        # povrsina izmedju funkcija f i g
    p2 = p2_1 + p2_2
    print('p2={0:.4f}'.format(p2))


    # d)

    y = np.abs(p1 - p2)
    plt.plot([a, b], [y, y], 'blue')

    f_y = lambda x: (f(x) - y)**2
    V = np.pi * nans_lib_2.integrate_simpson(f_y, a, b, 100)
    print('d) V={0:.4f}'.format(V))

    plt.show()
