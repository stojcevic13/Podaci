

def enter_number():
    while True:
        try:
            number = int(input("Unesite broj: "))
            return int(number)
        except ValueError:
            print("Greska u unosu!\n")


def str_rev(num):
    return str(num)[::-1]


def math_rev(num):
    reverse = 0
    power = len(str(num))-1
    mull = pow(10, power)
    while num > 10:
        reverse += (num % 10) * mull
        mull = mull // 10
        num = num // 10
    reverse += num
    return reverse


if __name__ == "__main__":
    num = enter_number()
    print(str_rev(num))
    print(math_rev(num))








