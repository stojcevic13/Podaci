from zadatak1 import UnsortedPriorityQueue

# def selection_sort_original(elements):   # O(n^2)
#     for i in range(len(elements)-1):
#         for j in range(i+1, len(elements)):
#             if elements[i] > elements[j]:
#                 elements[i], elements[j] = elements[j], elements[i]
#     return elements


def selection_sort(unsorted_list):
    unsorted_pq = UnsortedPriorityQueue()
    sorted_list = []
    for elem in unsorted_list:
        unsorted_pq.add(elem, elem)
    while not unsorted_pq.is_empty():
        sorted_list.append(unsorted_pq.remove_min().value)
    return sorted_list


if __name__ == '__main__':
    list1 = [2, 5, 6, 21, 43, 9, 3, 4, 1, 2, 90]
    sorted_list = selection_sort(list1)
    print(sorted_list)
