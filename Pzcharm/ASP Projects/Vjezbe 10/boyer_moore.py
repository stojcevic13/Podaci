ALPHABET = 'abcd'


def make_table(subtext):
    table = {}
    for i in range(len(subtext)):
        table[subtext[i]] = i
    for ch in ALPHABET:
        if ch not in table:
            table[ch] = -1
    return table


def boyer_moore(text, subtext):
    table = make_table(subtext)
    m = len(subtext)
    i, j = m - 1, m - 1
    while i < len(text):
        if text[i] == subtext[j]:
            i, j = i-1, j-1
            if j == 0:
                return i
        else:
            if j < table[text[i]]:
                i += m - j
            elif j > table[text[i]]:
                i += m - table[text[i]] - 1
            j = m - 1
    return -1


if __name__ == '__main__':
    pattern_1 = 'abcab'
    text = 'abaabccbdabcabbbab'
    index = boyer_moore(text, pattern_1)
    print(index)
