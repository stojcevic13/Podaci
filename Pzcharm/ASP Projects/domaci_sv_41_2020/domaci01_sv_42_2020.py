from tokenizer import tokenize
from stack import Stack


prioritet_operacija = {
    "+": 1,
    "-": 1,
    "*": 2,
    "/": 2,
    "^": 3,
    "s": 999
}

operacije_izraza = {}


def set_elements(operand1, operand2, token, stack):
    if prioritet_operacija[token] > 1:
        if prioritet_operacija[operacije_izraza[operand2]] < prioritet_operacija[token]:
            operand2 = f"({operand2})"
        if prioritet_operacija[operacije_izraza[operand1]] < prioritet_operacija[token]:
            operand1 = f"({operand1})"

    new_expression = f"{operand2} {token} {operand1}"
    stack.push(new_expression)
    operacije_izraza[new_expression] = token

    return operand1, operand2, stack


def postfix_to_infix(expression):
    global prioritet_operacija
    tokens = tokenize(expression)
    stack = Stack()

    for token in tokens:
        if token in prioritet_operacija:
            operand2 = stack.pop()
            operand1 = stack.pop()

            if operand2 not in operacije_izraza.keys():
                operacije_izraza[operand2] = "s"
            if operand1 not in operacije_izraza.keys():
                operacije_izraza[operand1] = "s"

            if token == "+" or token == "*":
                infix = operand1 + token + operand2
                stack.push(infix)
                operacije_izraza[infix] = token

            elif token == "*" or token == "/":
                if prioritet_operacija[operacije_izraza[operand1]] == 1:
                    operand1 = f"({operand1})"
                if prioritet_operacija[operacije_izraza[operand2]] == 1:
                    operand2 = f"({operand2})"
                infix = operand1 + token + operand2
                operacije_izraza[infix] = token
                stack.push(infix)

            elif token == "^":
                if prioritet_operacija[operacije_izraza[operand1]] <= 2:
                    operand1 = f"({operand1})"
                if prioritet_operacija[operacije_izraza[operand2]] <= 2:
                    operand2 = f"({operand2})"
                infix = operand1 + token + operand2
                operacije_izraza[infix] = token
                stack.push(infix)

        else:
            stack.push(token)

    return infix


if __name__ == "__main__":
    ex1 = "6.11 74 2 * -"
    ex2 = "24 7 - 3.2 7 + ^"
    ex3 = "20 7.9 * 3 7 - /"
#    postfix_expression = input("Unesite izraz: ")
    infix = postfix_to_infix(ex2)
    print(infix)
