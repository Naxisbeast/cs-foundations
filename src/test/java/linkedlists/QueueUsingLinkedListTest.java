package linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueUsingLinkedListTest {

    @Test
    void newQueueIsEmptyWithSizeZero() {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void enqueueAndDequeueFollowFifoOrder() {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        assertEquals(100, queue.dequeue());
        assertEquals(200, queue.dequeue());
        assertEquals(300, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void dequeueFromEmptyReturnsNull() {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        assertNull(queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    void peekReturnsFrontWithoutRemoving() {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(5);
        queue.enqueue(6);
        assertEquals(5, queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    void peekFromEmptyReturnsNull() {
        assertNull(new QueueUsingLinkedList().peek());
    }
}
