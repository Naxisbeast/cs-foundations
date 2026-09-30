package mini_projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A small to-do manager built on a hand-rolled linked list - the same
 * idea as SinglyLinkedList in data-structures/, but storing tasks that
 * can also be marked done. Adding walks to the tail (O(n)), which is
 * exactly the addLast cost documented for the linked list.
 */
public class TodoList {

    private static class Node {
        final String text;
        boolean done;
        Node next;

        Node(String text) {
            this.text = text;
        }
    }

    private Node head;
    private int size;

    public void add(String text) {
        Node node = new Node(text);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    /** Remove the first task with matching text. Returns true if one was removed. */
    public boolean remove(String text) {
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (current.text.equals(text)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    /** Flip the done flag on the first task with matching text. */
    public boolean toggle(String text) {
        Node current = head;
        while (current != null) {
            if (current.text.equals(text)) {
                current.done = !current.done;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /** All tasks in order, with a [x] marker on the completed ones. */
    public List<String> all() {
        List<String> result = new ArrayList<>();
        Node current = head;
        while (current != null) {
            result.add(current.done ? "[x] " + current.text : current.text);
            current = current.next;
        }
        return result;
    }

    public List<String> pending() {
        List<String> result = new ArrayList<>();
        Node current = head;
        while (current != null) {
            if (!current.done) {
                result.add(current.text);
            }
            current = current.next;
        }
        return result;
    }

    public List<String> completed() {
        List<String> result = new ArrayList<>();
        Node current = head;
        while (current != null) {
            if (current.done) {
                result.add(current.text);
            }
            current = current.next;
        }
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        TodoList list = new TodoList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("To-do list - add, done, remove, or list.");

        while (true) {
            System.out.print("\n> ");
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("q")) {
                break;
            }
            String[] parts = line.split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String rest = parts.length > 1 ? parts[1] : "";

            switch (command) {
                case "add":
                    list.add(rest);
                    System.out.println("Added: " + rest);
                    break;
                case "done":
                    list.toggle(rest);
                    System.out.println("Marked done: " + rest);
                    break;
                case "remove":
                    list.remove(rest);
                    System.out.println("Removed: " + rest);
                    break;
                case "list":
                    for (String task : list.all()) {
                        System.out.println("  " + task);
                    }
                    break;
                default:
                    System.out.println("Commands: add <task>, done <task>, remove <task>, list, quit");
            }
        }
        scanner.close();
    }
}
