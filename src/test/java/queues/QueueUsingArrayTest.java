package queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueUsingArrayTest {

    @Test
    void constructorRejectsNonPositiveCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new QueueUsingArray(0));
        assertThrows(IllegalArgumentException.class, () -> new QueueUsingArray(-1));
    }

    @Test
    void newQueueIsEmptyWithSizeZero() {
        QueueUsingArray queue = new QueueUsingArray(3);
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        assertEquals(0, queue.size());
    }

    @Test
    void enqueueAndDequeueFollowFifoOrder() {
        QueueUsingArray queue = new QueueUsingArray(3);
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        assertEquals(100, queue.dequeue());
        assertEquals(200, queue.dequeue());
        assertEquals(300, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void enqueueBeyondCapacityIsDropped() {
        QueueUsingArray queue = new QueueUsingArray(2);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3); // full: ignored by the implementation
        assertTrue(queue.isFull());
        assertEquals(2, queue.size());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void circularBufferReusesFreedSlots() {
        QueueUsingArray queue = new QueueUsingArray(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue()); // front now points at index 1
        queue.enqueue(4);                 // wraps around and writes to index 0
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void peekReturnsFrontWithoutRemoving() {
        QueueUsingArray queue = new QueueUsingArray(3);
        queue.enqueue(5);
        queue.enqueue(6);
        assertEquals(5, queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    void dequeueFromEmptyReturnsNull() {
        QueueUsingArray queue = new QueueUsingArray(2);
        assertNull(queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    void peekFromEmptyReturnsNull() {
        assertNull(new QueueUsingArray(1).peek());
    }
}
