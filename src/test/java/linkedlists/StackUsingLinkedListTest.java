package linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackUsingLinkedListTest {

    @Test
    void newStackIsEmptyWithSizeZero() {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void pushAndPopFollowLifoOrder() {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void popFromEmptyReturnsNull() {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        assertNull(stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void peekReturnsTopWithoutRemoving() {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(7);
        stack.push(9);
        assertEquals(9, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void peekFromEmptyReturnsNull() {
        assertNull(new StackUsingLinkedList().peek());
    }
}
