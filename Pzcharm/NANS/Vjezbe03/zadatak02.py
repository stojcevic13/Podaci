import numpy as np
from jacobi import jacobi

if __name__ == '__main__':
    A = np.array([
        [1.196, 0.3424, 0.1747],
        [0.2449, 1.0565, 0.0751],
        [0.198, 0.2661, 0.9159]
    ])
    b = np.array([-2.6827, -3.7424, 0.9456])
    x0 = np.array([1, 2, 3])

    print(jacobi(np.sin(A), b, x0))
