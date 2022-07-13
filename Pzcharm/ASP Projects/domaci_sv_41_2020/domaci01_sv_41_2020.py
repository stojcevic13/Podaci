from tokenizer import tokenize
from stack import Stack

unallowed_operators = "!@#$%&()_=[]{}\\|':;,<>?"


class UnallowedOperator(Exception):
    pass


class NonexsistentExpression(Exception):
    pass


class IncorrectExpression(Exception):
    pass


def correct_expression(expression):
    if expression == "":
        raise NonexsistentExpression("Nepostojeći izraz!")

    tokenize_expression = tokenize(expression)

    num_of_operations, num_of_operands = 0, 0
    for token in tokenize_expression:
        if token in unallowed_operators:
            raise UnallowedOperator("Unijeli ste neodgovarajući znak!")

        if token in operations:
            num_of_operations += 1
        else:
            num_of_operands += 1

    if num_of_operands != num_of_operations+1:
        raise IncorrectExpression("Visak operanada ili visak operatora!")

    return True


operations = {
    "+": 1,
    "-": 1,
    "*": 2,
    "/": 2,
    "^": 3,
    "(": 0,
    ")": None,
    "s": 999
}

operation = {}


def set_elements(operand1, operand2, token, stack):
    if operations[token] > 1:
        if operations[operation[operand2]] < operations[token]:
            operand2 = f"({operand2})"
        if operations[operation[operand1]] < operations[token]:
            operand1 = f"({operand1})"

    new_expression = f"{operand2} {token} {operand1}"
    stack.push(new_expression)
    operation[new_expression] = token

    return operand1, operand2, stack


def postfix_to_infix(expression):
    tokens = tokenize(expression)
    stack = Stack()

    for token in tokens:
        if token in operations:
            operand1 = stack.pop()
            operand2 = stack.pop()

            if operand2 not in operation.keys():
                operation[operand2] = "s"
            if operand1 not in operation.keys():
                operation[operand1] = "s"

            operand1, operand2, stack = set_elements(operand1, operand2, token, stack)

        else:
            stack.push(token)

    infix_notation = stack.pop()
    return infix_notation


if __name__ == "__main__":
    postfix_expression = input("Unesite izraz: ")
    if correct_expression(postfix_expression):
        infix = postfix_to_infix(postfix_expression)
        print(infix)
