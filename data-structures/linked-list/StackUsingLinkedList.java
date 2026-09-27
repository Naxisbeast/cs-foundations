package linkedlists;

/**
 * A LIFO stack built on the SinglyLinkedList.
 *
 * Same behaviour as the array-based StackUsingArray, but it grows without a
 * capacity limit because the linked list allocates nodes on demand.
 *
 * Time complexity:
 *   push  O(1)  — addFirst on the head
 *   pop   O(1)  — removeFirst from the head
 *   peek  O(1)
 * Space complexity: O(n) for the nodes.
 */
public class StackUsingLinkedList {

    private final SinglyLinkedList values = new SinglyLinkedList();

    public void push(int value) {
        values.addFirst(value);
    }

    public Integer pop() {
        return values.removeFirst();
    }

    public Integer peek() {
        return values.peekFirst();
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public int size() {
        return values.size();
    }
}
