import math
# Najveci prost djelilac zadatog broja n < 1 000 000 000


def nadji_najveci_prost_djelilac(n):
    djelilac = 2
    while n > 1:
        if n % djelilac == 0:
            n = n // djelilac
        else:
            djelilac += 1
    print(djelilac)


if __name__ == "__main__":
    nadji_najveci_prost_djelilac(19*19)