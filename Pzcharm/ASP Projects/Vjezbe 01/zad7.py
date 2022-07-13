def nzd(a, b):
    while b > 0:
        a, b = b, a % b
    return a


def nzs(a, b):
    veci = max(a, b)
    sad = veci
    while True:
        if sad % a == 0 and sad % b == 0:
            return sad
        sad += veci


if __name__ == "__main__":
    n = 1
    for i in range(1, 21):
        n = nzs(n, i)
    print(n)


