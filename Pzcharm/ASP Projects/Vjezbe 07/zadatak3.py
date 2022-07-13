from zadatak1 import SortedPriorityQueue


def insertion_sort(unsorted_list):
    sorted_pq = SortedPriorityQueue()
    sorted_list = []
    for elem in unsorted_list:
        sorted_pq.add(elem, elem)
    while not sorted_pq.is_empty():
        sorted_list.append(sorted_pq.remove_min().value)
    return sorted_list


if __name__ == '__main__':
    list1 = [2, 5, 6, 21, 43, 9, 3, 4, 1, 8, 90]
    sorted_list = insertion_sort(list1)
    print(sorted_list)
