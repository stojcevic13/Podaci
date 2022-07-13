# n-ti fibonacijev niz

def fib_binarno(n):
    if n <= 2:
        return 1
    else:
        return fib_binarno(n-1) + fib_binarno(n-2)


def fib_linearno(n):
    if n <= 1:
        return (1, 0)
    else:
        (a, b) = fib_linearno(n-1)
        return (a+b, a)


if __name__ == "__main__":
    fib = fib_linearno(6)
    print(fib[0])