import numpy as np
from gauss import gauss_vect


if __name__ == '__main__':
    A = np.array([
        [1., 0.1, (0.1*0.1), (0.1*0.1*0.1)],
        [1., 0.3, 0.3*0.3, 0.3*0.3*0.3],
        [1., 0.6, 0.6*0.6, 0.6*0.6*0.6],
        [1., 1.2, 1.2*1.2, 1.2*1.2*1.2]
    ])
    b = np.array([1.023, 1.261, 2.368, 9.064])
    print(np.linalg.solve(A, b))
