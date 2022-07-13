import numpy as np
import matplotlib.pyplot as plt


def show_sin_funcion():
    x = np.arange(0, 2*np.pi, 0.1)
    y_sin = np.sin(x)
    plt.plot(x, y_sin)
    plt.show()


def show_sin_cos():
    x = np.arange(0, 2*np.pi, 0.1)
    y_sin = np.sin(x)
    y_cos = np.cos(x)
    plt.plot(x, y_sin)
    plt.plot(x, y_cos)
    plt.title("Sinusna i kosinusna funkcija")
    plt.legend(['sinus', 'kosinus'])
    plt.show()


if __name__ == '__main__':
    show_sin_cos()
