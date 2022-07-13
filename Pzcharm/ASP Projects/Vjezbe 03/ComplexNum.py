class ComplexNumber(object):
    def __init__(self, real, i):
        self._real = real
        self._i = i

    @property
    def real(self):
        return self._real

    @property
    def i(self):
        return self._i

    @real.setter
    def real(self, real):
        self._real = real

    @i.setter
    def i(self, i):
        self._i = i

    def __str__(self):
        return f"{self._real} + {self._i}i"

    def __add__(self, other):
        real, i = self._real, self._i
        other_real, other_i = other.real, other.i
        return ComplexNumber(real + other_real, i + other_i)

    def __sub__(self, other):
        pass
        real, i = self._real, self._i
        other_real, other_i = other.real, other.i
        return ComplexNumber(real - other_real, i - other_i)

    def __mul__(self, other):
        real, i = self._real, self._i
        other_real, other_i = other.real, other.i
        return ComplexNumber(real*other_real - i*other_i, real*other_i + i*other_real)

    def __floordiv__(self, other):
        other.i *= -1
        divisor = other.real**2 + other.i**2
        z3 = self * other
        return ComplexNumber(z3.real // divisor, z3.i // divisor)




if __name__ == "__main__":
    z1 = ComplexNumber(4, 2)
    z2 = ComplexNumber(1, 1)
    print(z1 // z2)
