import numpy as np


if __name__ == '__main__':
    m = np.array([
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ])
    average = np.average(m)
    elems = m[m > average]
    print(np.sum(elems))
