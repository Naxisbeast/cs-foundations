"""A hash map from string keys to int values, with separate chaining.

This is the Python mirror of HashMapChaining.java. Python ships dict, so
the point is showing what actually happens underneath: hash the key, find
the bucket, walk the chain. Real maps resize when they get full; this one
has a fixed number of buckets, like the Java version.

Time: O(1) average, O(n) worst for put/get/remove.
"""


class HashMapChaining:
    def __init__(self, capacity):
        if capacity <= 0:
            raise ValueError("capacity must be positive")
        self._buckets = [[] for _ in range(capacity)]
        self._size = 0

    def _bucket_index(self, key):
        # Python's % always returns a non-negative result, so negative
        # hashCodes land in a valid bucket without extra handling.
        return hash(key) % len(self._buckets)

    def put(self, key, value):
        bucket = self._buckets[self._bucket_index(key)]
        for entry in bucket:
            if entry[0] == key:
                entry[1] = value
                return
        bucket.append([key, value])
        self._size += 1

    def get(self, key):
        bucket = self._buckets[self._bucket_index(key)]
        for entry in bucket:
            if entry[0] == key:
                return entry[1]
        return None

    def remove(self, key):
        bucket = self._buckets[self._bucket_index(key)]
        for index, entry in enumerate(bucket):
            if entry[0] == key:
                del bucket[index]
                self._size -= 1
                return True
        return False

    def size(self):
        return self._size


if __name__ == "__main__":
    mapping = HashMapChaining(8)
    mapping.put("alpha", 1)
    mapping.put("beta", 2)
    mapping.put("alpha", 99)
    print("alpha:", mapping.get("alpha"))
    print("size:", mapping.size())
    print("removed beta:", mapping.remove("beta"))
    print("beta after removal:", mapping.get("beta"))
