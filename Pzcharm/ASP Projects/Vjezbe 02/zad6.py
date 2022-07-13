def vrati_string(broj, osnova):
    cifre = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F']
    ispis = ""
    while broj >= 1:
        broj, ostatak = broj // osnova, broj % osnova
        ispis += cifre[ostatak]
    return ispis[::-1]


CIFRE = "0123456789ABCDEF"
def vrati_string_rekurzija(broj, osnova):
    if broj < osnova:
        return CIFRE[broj]
    else:
        return vrati_string_rekurzija(broj // osnova, osnova) + CIFRE[broj % osnova]


if __name__ == "__main__":
    ispis = vrati_string(32, 16)
    print(ispis)
    ispis2 = vrati_string_rekurzija(32, 16)
    print(ispis2)