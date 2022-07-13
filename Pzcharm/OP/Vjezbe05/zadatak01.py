

def load_txt_file(path):
    characters, letters, digits, words, statements = 0, 0, 0, 0, 0
    with open(path) as file:
        for char in file.read():
            if char.isalpha():
                letters += 1
            elif char.isdigit():
                digits += 1
            elif char.isspace():
                words += 1
            elif char == '.':
                statements += 1
            characters += 1
    print(f"Characters: {characters}")
    print(f'Letters: {letters}')
    print(f'Digits: {digits}')
    print(f'Words: {words}')
    print(f'Statements: {statements}')


if __name__ == '__main__':
    # load_txt_file('fajl.txt')

    chars, letters, digits, words, sentences = 0, 0, 0, 0, 0
    with open('fajl.txt') as file:
        while c := file.read(1):
            chars += 1
            if c.isalpha():
                letters += 1
            elif c.isdigit():
                digits += 1
            elif c.isspace():
                words += 1
            elif c == '.':
                sentences += 1

    print(f'Characters: {chars}')
    print(f'Letters: {letters}')
    print(f'Digits: {digits}')
    print(f'Words: {words}')
    print(f'Sentences: {sentences}')
