package stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackUsingArrayTest {

    @Test
    void constructorRejectsNonPositiveCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new StackUsingArray(0));
        assertThrows(IllegalArgumentException.class, () -> new StackUsingArray(-5));
    }

    @Test
    void newStackIsEmptyWithSizeZero() {
        StackUsingArray stack = new StackUsingArray(3);
        assertTrue(stack.isEmpty());
        assertFalse(stack.isFull());
        assertEquals(0, stack.size());
    }

    @Test
    void pushAndPopFollowLifoOrder() {
        StackUsingArray stack = new StackUsingArray(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void pushBeyondCapacityIsDropped() {
        StackUsingArray stack = new StackUsingArray(2);
        stack.push(1);
        stack.push(2);
        stack.push(3); // capacity reached: this push is ignored by the implementation
        assertTrue(stack.isFull());
        assertEquals(2, stack.size());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void popFromEmptyReturnsNullWithoutChangingSize() {
        StackUsingArray stack = new StackUsingArray(2);
        assertNull(stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void peekReturnsTopWithoutRemoving() {
        StackUsingArray stack = new StackUsingArray(2);
        stack.push(7);
        stack.push(9);
        assertEquals(9, stack.peek());
        assertEquals(2, stack.size());
        assertEquals(9, stack.pop());
    }

    @Test
    void peekFromEmptyReturnsNull() {
        assertNull(new StackUsingArray(1).peek());
    }
}
