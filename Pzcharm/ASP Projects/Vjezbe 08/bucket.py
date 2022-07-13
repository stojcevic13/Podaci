class Element(object):

    __slots__ = '_key', '_value'

    def __init__(self, key, value):
        self._key = key
        self._value = value

    @property
    def key(self):
        return self._key

    @property
    def value(self):
        return self._value

    @key.setter
    def key(self, key):
        self._key = key

    @value.setter
    def value(self, value):
        self._value = value

    def __str__(self):
        return str(self._key) + "-" + str(self._value)


class Bucket(object):

    def __init__(self):
        self._data = []

    def __getitem__(self, key):
        for item in self._data:
            if item.key == key:
                return item.value
        raise KeyError("Element with such key not found :(")

    def __setitem__(self, key, value):
        for item in self._data:
            if item.key == key:
                item.value = value
                return
        self._data.append(Element(key, value))

    def __delitem__(self, key):
        for item in self._data:
            if item.key == key:
                del self._data[self._data.index(item)]
                return
        raise KeyError("Element with such key not found :(")

    def __len__(self):
        return len(self._data)

    def __contains__(self, key):
        for item in self._data:
            if item.key == key:
                return True
        return False

    def __iter__(self):
        for item in self._data:
            yield item.key

    def items(self):
        for item in self._data:
            yield item.key, item.value

    def keys(self):
        keys = []
        for item in self._data:
            keys.append(item.key)
        return keys

    def values(self):
        values = []
        for item in self._data:
            values.append(item.value)
        return values

    def clear(self):
        self._data = []


if __name__ == '__main__':
    bucket = Bucket()
    bucket[2] = "dva"
    bucket['x'] = "men"
    bucket['asd'] = 'asdfgh'

    print(bucket['asd'])
    bucket[2] = "broj dva"
    print(bucket[2])

    if 2 in bucket:
        print("2 jeste kljuc")
    else:
        print("2 nije kljuc")
    del bucket[2]
    if 2 in bucket:
        print("2 jeste kljuc")
    else:
        print("2 nije kljuc")

    for key in bucket:
        print(key)

    print(bucket.values())
    print(bucket.keys())
    print(bucket.items())
