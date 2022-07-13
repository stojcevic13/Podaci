# najveci element niza rekurzivno

def maksimum(niz):
    if len(niz) <= 1:
        return niz[0]
    else:
        maks = maksimum(niz[1:])
        if maks > niz[0]:
            return maks
        else:
            return niz[0]


if __name__ == "__main__":
    maks = maksimum([3, 5, 11, 7, 4])
    print(maks)
