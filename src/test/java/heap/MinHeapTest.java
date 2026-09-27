package heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    @Test
    void newHeapIsEmptyWithSizeZero() {
        MinHeap heap = new MinHeap();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    void peekReturnsSmallestWithoutRemoving() {
        MinHeap heap = new MinHeap();
        heap.insert(10);
        heap.insert(3);
        heap.insert(7);
        assertEquals(3, heap.peek());
        assertEquals(3, heap.size());
    }

    @Test
    void extractMinReturnsValuesInAscendingOrder() {
        MinHeap heap = new MinHeap();
        for (int value : new int[]{9, 4, 7, 1, 8, 2, 5}) {
            heap.insert(value);
        }
        int[] extracted = new int[7];
        for (int i = 0; i < extracted.length; i++) {
            extracted[i] = heap.extractMin();
        }
        assertArrayEquals(new int[]{1, 2, 4, 5, 7, 8, 9}, extracted);
        assertTrue(heap.isEmpty());
    }

    @Test
    void extractMinHandlesDuplicates() {
        MinHeap heap = new MinHeap();
        heap.insert(3);
        heap.insert(3);
        heap.insert(1);
        heap.insert(3);
        assertEquals(1, heap.extractMin());
        assertEquals(3, heap.extractMin());
        assertEquals(3, heap.extractMin());
        assertEquals(3, heap.extractMin());
        assertTrue(heap.isEmpty());
    }

    @Test
    void extractMinOnEmptyHeapThrows() {
        MinHeap heap = new MinHeap();
        assertThrows(IllegalStateException.class, heap::extractMin);
        assertThrows(IllegalStateException.class, heap::peek);
    }

    @Test
    void singleElementHeap() {
        MinHeap heap = new MinHeap();
        heap.insert(42);
        assertEquals(42, heap.peek());
        assertEquals(42, heap.extractMin());
        assertTrue(heap.isEmpty());
    }

    @Test
    void largeInputMaintainsHeapProperty() {
        MinHeap heap = new MinHeap();
        for (int i = 1000; i >= 1; i--) {
            heap.insert(i);
        }
        int previous = Integer.MIN_VALUE;
        for (int i = 0; i < 1000; i++) {
            int current = heap.extractMin();
            assertTrue(current >= previous);
            previous = current;
        }
        assertTrue(heap.isEmpty());
    }
}
