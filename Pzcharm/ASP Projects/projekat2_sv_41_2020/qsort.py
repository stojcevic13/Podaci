"""
Modul sadrži implementaciju quick sort algoritma
"""
import random


def partition(a, left, right):
    """
    Funkcija vrši particionisanje niza nad zadatim intervalom

    Particionisanje niza vrši se dovođenjem elemenata u takav
    redosled da su svi elementi manji ili jednaki pivotu levo
    od njega, dok se elementi veći od pivota dovode na pozicije
    desno od njega.

    Argumenti:
    - `A`: niz koji se particioniše
    - `left`: indeks krajnjeg levog elementa
    - `right`: indeks krajnjeg desnog elementa
    """
    # poslednji element postaje pivot
    pivot = a[right]

    # varijabla čuva indeks krajnjeg levog elementa (pod)sekvence
    i = left-1

    for j in range(left, right):
        if a[j] <= pivot:
            i += 1
            a[i], a[j] = a[j], a[i]

    i = i+1
    a[i], a[right] = a[right], a[i]
    return i


def sort(a, left, right):
    """
    Quick sort algoritam

    Argumenti:
    - `A`: niz koji se sortira
    - `left`: indeks krajnjeg levog elementa
    - `right`: indeks krajnjeg desnog elementa
    """
    if left < right:
        pivot = partition(a, left, right)
        sort(a, left, pivot-1)
        sort(a, pivot+1, right)


def rpartition(a, left, right):
    """
    Funkcija vrši particionisanje niza nad zadatim intervalom

    Pre samog particionisanja niza, unosi se `šum` zamenom poslednjeg
    elementa niza (pivota) i nasumično odabranog elementa u nizu.

    Argumenti:
    - `A`: niz koji se particioniše
    - `left`: indeks krajnjeg levog elementa
    - `right`: indeks krajnjeg desnog elementa
    """
    i = random.randrange(left, right)
    a[right], a[i] = a[i], a[right]
    return partition(a, left, right)


def _rsort(a, left, right):
    if left < right:
        pivot = rpartition(a, left, right)
        _rsort(a, left, pivot-1)
        _rsort(a, pivot+1, right)


def rsort(a):
    """
    Quick sort uz randomized particionisanje

    Argumenti:
    - `A`: niz koji se sortira
    - `left`: indeks krajnjeg levog elementa
    - `right`: indeks krajnjeg desnog elementa
    """
    _rsort(a, 0, len(a)-1)


def tail_sort(a, left, right):
    """
    Quick sort, jedan rekurzivni poziv manje

    Argumenti:
    - `A`: niz koji se sortira
    - `left`: indeks krajnjeg levog elementa
    - `right`: indeks krajnjeg desnog elementa
    """
    while left < right:
        pivot = rpartition(a, left, right)
        tail_sort(a, left, pivot-1)
        left = pivot + 1
