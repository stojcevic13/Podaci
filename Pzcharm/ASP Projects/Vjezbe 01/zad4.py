
def generate_next(n):
    if n % 2 == 0:
        return n // 2
    else:
        return 3*n + 1


def make_array():
    all_lens = [0, 1]
    for i in range(2, 1000000):
        n = i
        duzina = 0
        while n > 1:
            n = generate_next(n)
            duzina += 1
            if n < i:
                duzina += all_lens[n]
                break
        all_lens.append(duzina)
    ponavljanje = max(all_lens)
    broj = all_lens.index(ponavljanje)
    print(broj, ponavljanje)


if __name__ == "__main__":
    make_array()


