package hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapChainingTest {

    @Test
    void constructorRejectsNonPositiveCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new HashMapChaining(0));
        assertThrows(IllegalArgumentException.class, () -> new HashMapChaining(-3));
    }

    @Test
    void putThenGetReturnsValue() {
        HashMapChaining map = new HashMapChaining(8);
        map.put("alpha", 1);
        assertEquals(1, map.get("alpha"));
        assertEquals(1, map.size());
    }

    @Test
    void putUpdatesExistingValue() {
        HashMapChaining map = new HashMapChaining(8);
        map.put("alpha", 1);
        map.put("alpha", 99);
        assertEquals(99, map.get("alpha"));
        assertEquals(1, map.size());
    }

    @Test
    void getMissingKeyReturnsNull() {
        HashMapChaining map = new HashMapChaining(8);
        map.put("alpha", 1);
        assertNull(map.get("missing"));
    }

    @Test
    void removeReturnsTrueOnlyWhenPresent() {
        HashMapChaining map = new HashMapChaining(8);
        map.put("alpha", 1);
        assertTrue(map.remove("alpha"));
        assertFalse(map.remove("alpha"));
        assertNull(map.get("alpha"));
        assertEquals(0, map.size());
    }

    @Test
    void collisionsAreHandledByChaining() {
        // Keys chosen so several share a bucket under a small capacity.
        HashMapChaining map = new HashMapChaining(4);
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);

        assertEquals(5, map.size());
        assertEquals(1, map.get("a"));
        assertEquals(5, map.get("e"));
        assertNull(map.get("zzz"));
    }

    @Test
    void manyKeysAllRetrievable() {
        HashMapChaining map = new HashMapChaining(16);
        for (int i = 0; i < 100; i++) {
            map.put("key-" + i, i);
        }
        assertEquals(100, map.size());
        assertEquals(42, map.get("key-42"));
        assertEquals(99, map.get("key-99"));
        assertNull(map.get("key-100"));
    }
}
