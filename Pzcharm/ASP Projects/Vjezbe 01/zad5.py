# zbir prostih brojeva 1 - 2 000 000
import math


def prost(n):
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    root = int(math.sqrt(n)) + 1
    for i in range(3, root, 2):
        if n % i == 0:
            return False
    return True


def brute_force():
    suma = 0
    for i in range(1, 2000000):
        if prost(i):
            suma += i
    print(suma)


def eratostenovo_sito():
    n = 2000000
    granica = int(math.sqrt(n)) + 1   # korijen

    prost = [True] * (n + 1)

    prost[0] = prost[1] = False

    # izbaci parne
    for i in range(4, n+1, 2):
        prost[i] = False

    for i in range(3, granica, 2):
        if prost[i]:
            for j in range(i*i, n, 2*i):
                prost[j] = False

    prosti_brojevi = [indeks for indeks, da_li_je_prost in enumerate(prost) if da_li_je_prost]
    suma = sum(prosti_brojevi)
    print(suma)



if __name__ == "__main__":
    eratostenovo_sito()


