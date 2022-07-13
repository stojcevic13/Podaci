def create_diamond(c, d):
    diamond1 = ''
    n = 2*d + 1
    i = 1
    for inc in (2, -2):
        while (i <= n-2 and inc == 2) or (i >= 1 and inc == -2):
            spaces = ' ' * ((n - i) // 2)
            chars = c * i
            diamond1 += spaces + chars + spaces + '\n'
            i += inc
    return diamond1


if __name__ == '__main__':
    c = input("Unesite znak: ")
    d = int(input("Unesite sirinu: "))
    with open('karo.txt', 'w') as file:
        diamond = create_diamond(c, d)
        file.write(diamond)
