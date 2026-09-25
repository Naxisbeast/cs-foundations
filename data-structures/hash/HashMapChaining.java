package hash;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * A hash map from String keys to int values using separate chaining
 * (a bucket of linked lists). Does not resize.
 *
 * Time complexity (average, with a good spread across buckets):
 *   put/get/remove   O(1)
 *   size             O(1)
 * Space complexity: O(capacity + entries).
 *
 * Math.floorMod handles negative hashCodes so every key lands in a valid
 * bucket. This is a teaching implementation; a production map resizes when
 * the load factor grows.
 */
public class HashMapChaining {

    private static class Entry {
        final String key;
        int value;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final LinkedList<Entry>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public HashMapChaining(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        buckets = (LinkedList<Entry>[]) new LinkedList[capacity];
        for (int index = 0; index < capacity; index++) {
            buckets[index] = new LinkedList<>();
        }
    }

    private int bucketIndex(String key) {
        return Math.floorMod(key.hashCode(), buckets.length);
    }

    /** Insert or update a key. */
    public void put(String key, int value) {
        int index = bucketIndex(key);
        for (Entry entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry(key, value));
        size++;
    }

    /** Return the value for a key, or null if the key is missing. */
    public Integer get(String key) {
        int index = bucketIndex(key);
        for (Entry entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    /** Remove a key. Returns true if it was present. */
    public boolean remove(String key) {
        int index = bucketIndex(key);
        Iterator<Entry> iterator = buckets[index].iterator();
        while (iterator.hasNext()) {
            if (iterator.next().key.equals(key)) {
                iterator.remove();
                size--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }
}
