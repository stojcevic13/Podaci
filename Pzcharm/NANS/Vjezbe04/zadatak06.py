import numpy as np
import matplotlib.pyplot as plt
import sympy as sym

import zero_false_position


if __name__ == '__main__':
    f = lambda x: np.sin(2*x) - x
    # df = lambda x: -2*np.cos(2*x) - 1
    a, b = 0, 2*np.pi

    x_sym = sym.Symbol('x')
    df_sym = sym.diff(sym.sin(2 * x_sym) - x_sym)
    df = sym.lambdify(x_sym, df_sym, 'numpy')

    x = np.linspace(a, b, 100)
    plt.plot(x, f(x), 'blue')
    plt.plot(x, df(x), 'red')
    plt.plot([a, b], [0, 0], 'black')

    max, _ = zero_false_position.zero_false_position(df, 0, 1)
    print('max = ', max)
    fMax = f(max)
    plt.scatter(max, fMax, c='g')
    min, _ = zero_false_position.zero_false_position(df, 5, 6)
    print('min = ', min)
    fMin = f(min)
    plt.scatter(min, fMin, c='g')

    plt.show()
