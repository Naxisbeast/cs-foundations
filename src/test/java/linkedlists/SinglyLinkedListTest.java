package linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void newListIsEmptyWithSizeZero() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void addFirstPrepends() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(20);
        list.addFirst(10);
        assertEquals(10, list.removeFirst());
        assertEquals(20, list.removeFirst());
        assertTrue(list.isEmpty());
    }

    @Test
    void addLastAppends() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        assertEquals(10, list.removeFirst());
        assertEquals(20, list.removeFirst());
        assertTrue(list.isEmpty());
    }

    @Test
    void removeFirstOnEmptyReturnsNull() {
        assertNull(new SinglyLinkedList().removeFirst());
    }

    @Test
    void containsFindsPresentAndAbsentValues() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        assertTrue(list.contains(10));
        assertTrue(list.contains(30));
        assertFalse(list.contains(99));
    }

    @Test
    void duplicatesAreStoredAndRemovedIndividually() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(10);
        list.addFirst(10);
        assertEquals(2, list.size());
        list.removeFirst();
        assertEquals(1, list.size());
        assertTrue(list.contains(10));
    }

    @Test
    void addLastOnEmptyListSetsHead() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(7);
        assertEquals(7, list.removeFirst());
        assertTrue(list.isEmpty());
    }

    @Test
    void sizeTracksElementsAcrossOperations() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertEquals(0, list.size());
        list.addFirst(1);
        list.addLast(2);
        assertEquals(2, list.size());
        list.removeFirst();
        assertEquals(1, list.size());
    }
}
