import numpy as np
import matplotlib.pyplot as plt
from math import pi
from mpl_toolkits.mplot3d import Axes3D


def nacrtaj_sin():
    x = np.arange(0, 2*pi, 0.1)
    y = np.sin(x)
    plt.plot(x, y)
    plt.show()


def nacrtaj_zbir():
    x = np.arange(-5, 5, 0.1)
    y = np.sin(x) + np.cos(x)
    # plt.plot()
    plt.plot(x, y)
    plt.show()
    # Axes3D.plot(x, x, y)
    # Axes3D.matshow()


if __name__ == '__main__':
    nacrtaj_zbir()
