import numpy as np


def replace_gl_sp(matrix):
    rows, cols = np.shape(matrix)
    gl, sp = 0, cols-1
    for row in range(rows):
        matrix[row, gl], matrix[row, sp] = matrix[row, sp], matrix[row, gl]
        gl, sp = gl + 1, sp - 1
    return matrix


if __name__ == '__main__':
    m = np.array([
        [-0.5, 10, 2],
        [-1, 1, 0],
        [1, -6, -3]
    ])
    print(replace_gl_sp(m))
