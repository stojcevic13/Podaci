import numpy as np
import matplotlib.pyplot as plt
import NANS_lib


if __name__ == '__main__':
    f = lambda x: np.sqrt(2)*np.sin(2*x) + np.cos(-x/3)
    a, b = -np.pi/2, 4*np.pi/3
    x = np.linspace(a, b, 100)
    fx = f(x)
    plt.plot(x, fx, 'blue')

    # pod b

    x5 = np.linspace(a, b, 5)
    fx5 = f(x5)
    plt.scatter(x5, fx5, c='black')

    # pod c

    p4 = NANS_lib.lagrange_interpolation(x5, fx5)
    px4 = lambda x: np.polyval(p4, x)
    plt.plot(x, px4(x), 'red')
    print(f'{np.round(p4[0], 2)}x^4{np.round(p4[1], 2)}x^3{np.round(p4[2], 2)}x^2+{np.round(p4[3], 2)}x+{np.round(p4[4], 2)}')

    # pod d

    p3 = NANS_lib.least_squares_regression(x, fx, 3)
    px3 = lambda x: np.polyval(p3, x)
    plt.plot(x, px3(x), 'brown')
    print(f'{np.round(p3[0], 2)}x^3{np.round(p3[1], 2)}x^2+{np.round(p3[2], 2)}x+{np.round(p3[3], 2)}')

    # pod e

    h = lambda x: np.polyval(p4, x) - np.polyval(p3, x)
    pr1, _ = NANS_lib.zeroFalsePosition(h, -0.5, -1)
    plt.scatter(pr1, px4(pr1), c='green')
    pr2, _ = NANS_lib.zeroFalsePosition(h, 0, 0.5)
    plt.scatter(pr2, px4(pr2), c='green')
    pr3, _ = NANS_lib.zeroFalsePosition(h, 2.1, 2.6)
    plt.scatter(pr3, px4(pr3), c='green')
    print('\nPresjeci polinoma 3. i 4. stepena:')
    print(f'({np.round(pr1, 2)}, {np.round(px4(pr1), 2)})')
    print(f'({np.round(pr2, 2)}, {np.round(px4(pr2), 2)})')
    print(f'({np.round(pr3, 2)}, {np.round(px4(pr3), 2)})')

    plt.show()
