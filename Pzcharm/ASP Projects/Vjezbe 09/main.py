from merge_sort import merge_sort
from quick_sort import quick_sort
from bucket_sort import bucket_sort
from random import randint
import time


def create_unsorted_list():
    unsorted = []
    for i in range(200000):
        unsorted.append(randint(0, 200000))
    return unsorted


def sort_test(func):
    unsorted_list = create_unsorted_list()
    start = time.time()
    func(unsorted_list)
    end = time.time()
    print(end - start)


if __name__ == '__main__':
    '''SORTIRANJE 1000 ELEMENATA'''

    sort_test(merge_sort)

    unsorted_list = create_unsorted_list()
    start = time.time()
    sorted_list = quick_sort(unsorted_list, 0, len(unsorted_list)-1)
    end = time.time()
    print(end - start)

    unsorted_list = create_unsorted_list()
    start = time.time()
    bucket_sort(unsorted_list, 200001)
    end = time.time()
    print(end-start)
