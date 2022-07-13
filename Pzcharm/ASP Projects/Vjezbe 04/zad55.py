# 3 + 2 --> 3 2 +
# 4 * 3 + 9 --> 4 3 * 9 +     4 * (3 + 9) --> 4 3 9 + *
# 7 - 3 * 2 --> 7 3 2 * -     (7 - 3) * 2 --> 7 3 - 2 *

from stack import Stack

priority = {
    "+": 1,
    "-": 1,
    "*": 2,
    "/": 2,
    "^": 3,
    "(": 0,
    ")": None
}


def infix_to_postfix(expression):
    stack = Stack()
    postfix = []
    tokens = expression.split(" ")

    for token in tokens:
        if token in priority.keys():
            if token == "(":
                stack.push(token)
            elif token == ")":
                top = stack.pop()
                while top != "(":
                    postfix.append(top)
                    top = stack.pop()
            else:
                while not stack.is_empty() and priority[token] <= priority[stack.top()]:
                    postfix.append(stack.pop())
                stack.push(token)
        else:
            postfix.append(token)

    while not stack.is_empty():
        postfix.append(stack.pop())

    return postfix

if __name__ == '__main__':
    postfix = " ".join(infix_to_postfix("8 - 4 * 3"))
    print(postfix)
