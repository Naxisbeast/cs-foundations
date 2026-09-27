package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary search tree storing ints. Duplicates are ignored.
 *
 * Time complexity (balanced tree):
 *   insert/contains/min/max/delete   O(log n) average, O(n) worst (skewed tree)
 *   inOrder/preOrder/postOrder       O(n)
 *   height                           O(n)
 * Space complexity: O(n) for the tree itself; the recursion stack is O(height).
 *
 * delete handles the three classic cases: a leaf, a node with one child,
 * and a node with two children (which is replaced by its in-order
 * successor — the smallest value in the right subtree).
 */
public class BinarySearchTree {

    private Node root;
    private int size;

    private static class Node {
        // Not final: the two-child delete replaces a node's value with its
        // in-order successor's value, so the value must be reassignable.
        int value;
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
        return minNode(root).value;
    }

    private Node minNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int max() {
        if (root == null) {
            throw new IllegalStateException("Cannot find max of an empty tree.");
        }
        return maxNode(root).value;
    }

    private Node maxNode(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /** Delete a value. Returns true if it was present and removed. */
    public boolean delete(int value) {
        if (!contains(value)) {
            return false;
        }
        root = deleteNode(root, value);
        size--;
        return true;
    }

    private Node deleteNode(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else if (node.left == null) {
            return node.right;       // one child (right) or a leaf
        } else if (node.right == null) {
            return node.left;        // one child (left)
        } else {
            // Two children: replace with the in-order successor, then
            // delete that successor from the right subtree.
            node.value = minNode(node.right).value;
            node.right = deleteNode(node.right, node.value);
        }
        return node;
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

    /** Pre-order traversal: root, then left, then right. */
    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.value);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }

    /** Post-order traversal: left, then right, then root. */
    public List<Integer> postOrder() {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postOrder(node.left, result);
        postOrder(node.right, result);
        result.add(node.value);
    }
}
