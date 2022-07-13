

def bucket_sort(s, num_of_elements):
    sorted_list = []
    bucket = ['-'] * num_of_elements
    for elem in s:
        bucket[elem] = elem
    for elem in bucket:
        if elem != '-':
            sorted_list.append(elem)


if __name__ == '__main__':
    s = [9, 6, 8, 1, 7, 3, 5, 4]
    bucket_sort(s, 400)
