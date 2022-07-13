from zad1 import str_rev

def palindrom(num):
    if str(num) == str_rev(num):
        return True
    return False


def max_palindrom_999_100():
    curr_palindrom = 0
    for i in range(999, 100, -1):
        for j in range(999, i-1, -1):
            result = i * j
            if result < curr_palindrom:
                break
            if palindrom(result):
                curr_palindrom = result
                break
    return curr_palindrom

if __name__ == "__main__":
    max_palindrom = max_palindrom_999_100()
    print(max_palindrom)

