from random import randrange


def partition(s, left, right):
    i = randrange(left, right)
    s[right], s[i] = s[i], s[right]

    pivot = s[right]
    index = left-1
    for j in range(left, right):
        if s[j] <= pivot:
            index += 1
            s[index], s[j] = s[j], s[index]
    index += 1
    s[index], s[right] = s[right], s[index]
    return index


def quick_sort(s, left, right):
    if left < right:  # ako je vise od jednog elementa u listi
        pivot = partition(s, left, right)

        # pivot = randrange(left, right)
        # s[pivot], s[right] = s[right], s[pivot]
        # last = right
        # right -= 1
        # while left < right:
        #     while s[left] < s[last]:
        #         left += 1
        #     while s[right] > s[last]:
        #         right -= 1
        #     if left <= right:
        #         s[left], s[right] = s[right], s[left]
        # s[last], s[left] = s[left], s[last]

        quick_sort(s, left, pivot-1)
        quick_sort(s, pivot+1, right)


if __name__ == '__main__':
    s = [9, 6, 8, 1, 7, 3, 5, 4]
    quick_sort(s, 0, len(s)-1)
    print(s)
