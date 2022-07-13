# reimplikacija

def reimplikacija(a, b):
    if b <= 1:
        return [a]
    else:
        return [a] + reimplikacija(a, b-1)


if __name__ == "__main__":
    niz = reimplikacija(5, 6)
    print(niz)