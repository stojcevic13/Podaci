from stack import Stack

def calculate(a, b, operation):
    if operation == "+":
        return a + b
    elif operation == "-":
        return a - b
    elif operation == "*":
        return a * b
    elif operation == "/":
        return a / b


operations = "+-*/"


def get_result(postfix):
    stack = Stack()
    tokens = postfix.split(" ")

    for token in tokens:
        if token not in operations:
            stack.push(int(token))
        else:
            a = stack.pop()
            b = stack.pop()
            result = calculate(b, a, token)
            stack.push(result)

    return stack.pop()


if __name__ == '__main__':
    result = get_result("7 3 2 * -")
    print(result)
