import numpy as np
import matplotlib.pyplot as plt
import nans_lib_1
import sympy as sym


if __name__ == '__main__':
    f = lambda x: x*np.cos(2*x) - 2
    x_sym = sym.Symbol('x')
    df_sym = sym.diff(x_sym * sym.cos(2 * x_sym) - 2)
    df = sym.lambdify(x_sym, df_sym, 'numpy')

    a, b = -5*np.pi/3, 3*np.pi/4
    x = np.linspace(a, b, 100)
    plt.plot(x, f(x))
    plt.plot([a, b], [0, 0], 'black')

    zero, _ = nans_lib_1.zeroNewton(f, df, -4.5)
    plt.scatter(zero, f(zero), c='y')
    print(f'b) x = {zero}')

    max, _ = nans_lib_1.zeroSecant(df, -5, -4)
    plt.scatter(max, f(max), c='g')
    min, _ = nans_lib_1.zeroSecant(df, -4, -3)
    plt.scatter(min, f(min), c='g')
    print(f'c) xmin = {min}\nd) xmax = {max}')

    g = lambda x: -np.sin(x)*np.exp(x) - 2
    plt.plot(x, g(x), 'red')

    f_dif = lambda x: f(x) - g(x)
    p1, _ = nans_lib_1.zeroFalsePosition(f_dif, -1.5, -0.5)
    plt.scatter(p1, f(p1), c='c')
    p2, _ = nans_lib_1.zeroFalsePosition(f_dif, -0.5, 1)
    plt.scatter(p2, f(p2), c='c')
    p3, _ = nans_lib_1.zeroFalsePosition(f_dif, -4, -3.5)
    plt.scatter(p3, f(p3), c='c')
    p4, _ = nans_lib_1.zeroFalsePosition(f_dif, -3, -2)
    plt.scatter(p4, f(p4), c='c')


    plt.show()
