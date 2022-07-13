
#  1 1 2 3 5 8 13 21 34 55 89 144...
#  3 -- 13
#  13 -- 55

def fib_sum():
    GRANICA = 4000000
    prethodni, trenutni, suma = 2, 3, 0
    while prethodni < GRANICA:
        suma += prethodni
        novi_prethodni = prethodni + 2*trenutni
        novi_trenutni = 3*trenutni + 2*prethodni

        prethodni, trenutni = novi_prethodni, novi_trenutni
    return suma


if __name__ == "__main__":
    suma = fib_sum()
    print(suma)
