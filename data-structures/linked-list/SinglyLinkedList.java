package linkedlists;

public class SinglyLinkedList {
    private Node head;
    private int size;

    private static class Node {
        private final int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            size++;
            return;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        size++;
    }

    public Integer removeFirst() {
        // I check whether the list is empty before removing a node.
        if (isEmpty()) {
            System.out.println("The list is empty. There is no first value to remove.");
            return null;
        }

        int removedValue = head.value;
        head = head.next;
        size--;
        return removedValue;
    }

    public boolean contains(int value) {
        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List: empty");
            return;
        }

        System.out.print("List: ");
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value);
            if (currentNode.next != null) {
                System.out.print(" -> ");
            }
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
