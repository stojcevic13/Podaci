import numpy as np
import matplotlib.pyplot as plt
import sympy as sym
import NANS_lib


if __name__ == '__main__':
    f = lambda x: np.sin(x**2 - 2)
    g = lambda x: x*np.cos(x)

    a, b = -3, 1
    x = np.linspace(a, b, 100)
    fx, gx = f(x), g(x)

    # pod a

    plt.plot(x, fx, 'blue')
    plt.plot(x, gx, 'red')
    plt.plot([a, b], [0, 0], 'black')

    # pod b

    zero1, _ = NANS_lib.zeroFalsePosition(f, a, -2.5)
    plt.scatter(zero1, f(zero1), c='green')
    zero2, _ = NANS_lib.zeroFalsePosition(f, -2.5, -2)
    plt.scatter(zero2, f(zero2), c='green')
    zero3, _ = NANS_lib.zeroFalsePosition(f, -1.5, -1)
    plt.scatter(zero3, f(zero3), c='green')

    # pod c

    h = lambda x: f(x) - g(x)
    p1, _ = NANS_lib.zeroFalsePosition(h, -2.2, -1.7)
    plt.scatter(p1, f(p1), c='purple')
    p2, _ = NANS_lib.zeroFalsePosition(h, -1.5, -1.1)
    plt.scatter(p2, f(p2), c='purple')

    # pod d

    x_sym = sym.Symbol('x')
    df_sym = sym.diff(sym.sin(x_sym**2 - 2))
    df = sym.lambdify(x_sym, df_sym, 'numpy')

    dg_sym = sym.diff(x_sym * sym.cos(x_sym))
    dg = sym.lambdify(x_sym, dg_sym, 'numpy')

    max_f, _ = NANS_lib.zeroFalsePosition(df, -2, -1.5)
    plt.scatter(max_f, f(max_f), c='black')
    min_g, _ = NANS_lib.zeroFalsePosition(dg, -2, -1.5)
    plt.scatter(min_g, g(min_g), c='gray')

    print(f'max_f = {np.round(max_f, 2)}, f(max_f) = {np.round(f(max_f), 2)}')
    print(f'min_g = {np.round(min_g, 2)}, g(min_g) = {np.round(g(min_g), 2)}')

    # pod e

    val = np.pi/6
    plt.plot([a, b], [val, val], 'lightgray')

    fp = lambda x: f(x) - val
    p1, _ = NANS_lib.zeroFalsePosition(fp, a, -2.7)
    plt.scatter(p1, f(p1), c='orange')
    p2, _ = NANS_lib.zeroFalsePosition(fp, -2.5, -2)
    plt.scatter(p2, f(p2), c='orange')
    p3, _ = NANS_lib.zeroFalsePosition(fp, -1.7, -1.3)
    plt.scatter(p3, f(p3), c='orange')

    gp = lambda x: g(x) - val
    p4, _ = NANS_lib.zeroFalsePosition(gp, -2, -1.5)
    plt.scatter(p4, g(p4), c='orange')
    p5, _ = NANS_lib.zeroFalsePosition(gp, 0.5, 0.8)
    plt.scatter(p5, g(p5), c='orange')
    # p6, _ = NANS_lib.zeroFalsePosition(gp, 0.8, b)
    # plt.scatter(p6, g(p6), c='orange')

    print('\nTacke presjeka funkcije f(x) i x=pi/6:')
    print(f'({np.round(p1, 2)}, {np.round(f(p1), 2)})')
    print(f'({np.round(p2, 2)}, {np.round(f(p2), 2)})')
    print(f'({np.round(p3, 2)}, {np.round(f(p3), 2)})')
    print('Tacke presjeka funkcije g(x) i x=pi/6:')
    print(f'({np.round(p4, 2)}, {np.round(g(p4), 2)})')
    print(f'({np.round(p5, 2)}, {np.round(g(p5), 2)})')
    # print(f'({np.round(p6, 2)}, {np.round(g(p6), 2)})')

    plt.show()
