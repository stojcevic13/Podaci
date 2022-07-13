from stack import *

CIFRE = "0123456789ABCDEF"


def convert_to(num, base):
    stek = Stack()
    num_str = ""
    while num != 0:
        num, rest = num // base, num % base
        stek.push(CIFRE[rest])
    while not stek.is_empty():
        num_str += stek.pop()
    return num_str


DIGITS = "0123456789ABCDEF"


def convert_to_recursion(num, base, stack):
    if num < base:
        stack.push(DIGITS[num])
    else:
        stack.push(DIGITS[num % base])
        convert_to_recursion(num // base, base, stack)


if __name__ == "__main__":
    stack = Stack()
    convert_to_recursion(734, 16, stack)
    output = ""
    while not stack.is_empty():
        output += stack.pop()
    print(output)

