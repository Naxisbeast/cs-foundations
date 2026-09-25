package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary search tree storing ints. Duplicates are ignored.
 *
 * Time complexity (balanced tree):
 *   insert/contains/min/max   O(log n) average, O(n) worst (skewed tree)
 *   inOrder                   O(n)
 *   height                    O(n)
 * Space complexity: O(n) for the tree itself; the recursion stack is O(height).
 */
public class BinarySearchTree {

    private Node root;
    private int size;

    private static class Node {
        final int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    /** Insert a value. Returns true if it was added, false if it was already present. */
    public boolean insert(int value) {
        int sizeBefore = size;
        root = insertNode(root, value);
        return size > sizeBefore;
    }

    private Node insertNode(Node node, int value) {
        if (node == null) {
            size++;
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insertNode(node.left, value);
        } else if (value > node.value) {
            node.right = insertNode(node.right, value);
        }
        return node;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.value) {
            return true;
        }
        if (value < node.value) {
            return contains(node.left, value);
        }
        return contains(node.right, value);
    }

    public int min() {
        if (root == null) {
            throw new IllegalStateException("Cannot find min of an empty tree.");
        }
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    public int max() {
        if (root == null) {
            throw new IllegalStateException("Cannot find max of an empty tree.");
        }
        Node node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    /** Height of the tree: -1 for an empty tree, 0 for a single node. */
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** In-order traversal: values come out in ascending order. */
    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrder(node.left, result);
        result.add(node.value);
        inOrder(node.right, result);
    }
}
