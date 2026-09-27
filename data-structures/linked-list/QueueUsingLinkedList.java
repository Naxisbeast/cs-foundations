package linkedlists;

/**
 * A FIFO queue built on the SinglyLinkedList.
 *
 * Dequeue is O(1) at the head; enqueue appends at the tail and therefore
 * walks the whole list, so it is O(n). A version with a tail pointer would
 * make enqueue O(1) — see MyLinkedList in the academic-assignments folder,
 * which keeps a tail reference for exactly that reason.
 *
 * Time complexity:
 *   enqueue  O(n)  — walks to the tail
 *   dequeue  O(1)  — removes the head
 *   peek     O(1)
 * Space complexity: O(n) for the nodes.
 */
public class QueueUsingLinkedList {

    private final SinglyLinkedList values = new SinglyLinkedList();

    public void enqueue(int value) {
        values.addLast(value);
    }

    public Integer dequeue() {
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
