# 3 + 2 --> 3 2 +
# 4 * 3 + 9 --> 4 3 * 9 +     4 * (3 + 9) --> 4 3 9 + *
# 7 - 3 * 2 --> 7 3 2 * -     (7 - 3) * 2 --> 7 3 - 2 *

from stack import Stack

OPERATORI = {
    "+": 1,
    "-": 1,
    "*": 2,
    "/": 2
}


def infix_to_postfix(izraz):
    stack = Stack()
    output = ""
    brackets = 0
    for char in izraz:

        if char == "(":
            brackets += 2
        elif char == ")":
            brackets -= 2
        elif char not in OPERATORI:
            output += char
        else:
            OPERATORI[char] += brackets
            if not stack.is_empty():  # da je bilo i stepenovanje, islo bi while umjesto if
                if OPERATORI[char] <= OPERATORI[stack.top()]:
                    output += stack.pop()
            stack.push(char)

    while not stack.is_empty():
        output += stack.pop()

    return output


if __name__ == "__main__":
    izraz = "4*(3+9)+3*2"
    postfix = infix_to_postfix(izraz)
    print(postfix)
