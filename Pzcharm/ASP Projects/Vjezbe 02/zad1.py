# suma prvih n prirodnih brojeva rekurzija

def suma(n):
    if n <= 1:
        return n
    return n + suma(n-1)


if __name__ == "__main__":
    print(suma(9))
