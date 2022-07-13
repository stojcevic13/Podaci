import random
from bucket import Element, Bucket


class HashMap(object):

    def __init__(self, capacity=8):
        self._data = capacity * [None]
        self._capacity = capacity
        self._size = 0

        self._prime = 109345121    # prost broj za Hash funkciju
        self._a = 1 + random.randrange(self._prime - 1)
        self._b = random.randrange(self._prime)

    def __len__(self):
        return self._size

    def _hash(self, x):
        hashed_value = (hash(x)*self._a + self._b) % self._prime
        compressed = hashed_value % self._capacity
        return compressed

    def _resize(self, capacity):
        old_data = self.items()
        self._data = capacity * [None]
        self._capacity = capacity
        self._size = 0

        for (k, v) in old_data:
            self[k] = v

    def __getitem__(self, key):
        index = self._hash(key)
        return self._bucket_getitem(index, key)

    def __setitem__(self, key, value):
        index = self._hash(key)
        self._bucket_setitem(index, key, value)

        if self._size > self._capacity // 2:
            self._resize(self._capacity * 2)

    def __delitem__(self, key):
        index = self._hash(key)
        self._bucket_delitem(index, key)
        self._size -= 1

    def items(self):
        raise NotImplementedError()

    def _bucket_getitem(self, index, key):
        raise NotImplementedError()

    def _bucket_setitem(self, index, key, value):
        raise NotImplementedError()

    def _bucket_delitem(self, index, key):
        raise NotImplementedError()


class HashMapBucket(HashMap):

    """Ne treba __init__ jer je to vec napravljeno u nadklasi, a nema dodatnih atributa"""

    def _bucket_getitem(self, index, key):
        bucket = self._data[index]
        if bucket is None:
            raise KeyError("No such key!")
        return bucket[key]

    def _bucket_setitem(self, index, key, value):
        bucket = self._data[index]
        if bucket is None:
            self._data[index] = Bucket()
        old_bucket_size = len(self._data[index])
        self._data[index][key] = value
        new_bucket_size = len(self._data[index])
        self._size += new_bucket_size - old_bucket_size

    def _bucket_delitem(self, index, key):
        bucket = self._data[index]
        if bucket is None:
            raise KeyError("No such key!")
        del bucket[key]

    def __iter__(self):
        for bucket in self._data:
            if bucket is not None:
                for key in bucket:
                    yield key

    def items(self):
        for bucket in self._data:
            if bucket is not None:
                for key, value in bucket.items():
                    yield key, value


class LinearHashMap(HashMap):

    _MARKER = object()

    def _is_available(self, index):
        """Da li je bucket sa zadatim indeksom slobodan"""
        return self._data[index] is self._MARKER or self._data[index] is None

    def _find_object(self, index, key):
        """Pronalazi bucket koji sadrzi element sa zadatim kljucem"""

        available_index = None
        while True:
            if self._is_available(index):
                if available_index is None:
                    available_index = index

                if self._data[index] is None:
                    return False, available_index

            elif self._data[index].key == key:
                return True, index

            index = (index + 1) % self._capacity

    def _bucket_getitem(self, index, key):
        found, index = self._find_object(index, key)
        if not found:
            raise KeyError("No such key!")
        return self._data[index].value

    def _bucket_setitem(self, index, key, value):
        found, bucket_index = self._find_object(index, key)
        if not found:
            self._data[bucket_index] = Element(key, value)
            self._size += 1
        else:
            self._data[bucket_index].value = value

    def _bucket_delitem(self, index, key):
        found, bucket_index = self._find_object(index, key)
        if not found:
            raise KeyError("No such index!")
        self._data[bucket_index] = self._MARKER

    def __iter__(self):
        for i in range(len(self._data)):
            if not self._is_available(i):
                yield self._data[i].key

    def items(self):
        for i in range(len(self._data)):
            if not self._is_available(i):
                yield self._data[i].key, self._data[i].value


if __name__ == '__main__':
    # hashmap = HashMapBucket()
    # hashmap[45] = "ceteres pet"
    # print(hashmap[45])
    # hashmap[45] = "45..."
    # print(hashmap[45])

    hashmap2 = LinearHashMap()
    hashmap2[10] = "deset"
    del hashmap2[10]
    hashmap2[12] = "dvanes"
    print(hashmap2[12])
    hashmap2[13] = "trines"

    for item in hashmap2:
        print(item, hashmap2[item])
