import numpy as np

if __name__ == '__main__':
    A = np.array([
        [-3, -2, -3],
        [-3, 0, -5],
        [-1, -4, 5],
    ])
    b = np.array([11, 7, 5])
    x = np.linalg.solve(A, b)
    print(x)
