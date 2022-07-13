

def merge(s1, s2, s3):
    i, j = 0, 0
    while i + j < len(s3):
        if j >= len(s2) or (i < len(s1) and s1[i] <= s2[j]):
            s3[i + j] = s1[i]
            i += 1
        else:
            s3[i + j] = s2[j]
            j += 1
    return s3


def merge_sort(s3):
    if len(s3) == 1:
        return [s3[0]]
    if len(s3) == 0:
        return []

    middle = len(s3) // 2
    s1 = merge_sort(s3[0:middle])
    s2 = merge_sort(s3[middle:])
    s3 = merge(s1, s2, s3)
    return s3


if __name__ == '__main__':
    s = [9, 6, 8, 1, 7, 3, 8, 9]
    s = merge_sort(s)
    print(s)
