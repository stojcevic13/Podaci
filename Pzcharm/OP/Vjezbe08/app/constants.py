#!/usr/bin/python

ATTRIBUTES = ["id", "sifra", "dolazak", "celija", "kazna", "status"]
FMT = "i7s20s5sii"
CODING = "ascii"

F = 4
B = 5


if __name__ == '__main__':
    if not (block := []):
        print("da")
    else:
        print("ne")
