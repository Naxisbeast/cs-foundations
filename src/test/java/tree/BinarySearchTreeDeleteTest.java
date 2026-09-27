package tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeDeleteTest {

    private BinarySearchTree treeWith(int... values) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int value : values) {
            tree.insert(value);
        }
        return tree;
    }

    @Test
    void deleteLeafRemovesItAndKeepsOthers() {
        // Tree: root 5, left 3, right 8 — deleting leaf 3.
        BinarySearchTree tree = treeWith(5, 3, 8);
        assertTrue(tree.delete(3));
        assertFalse(tree.contains(3));
        assertEquals(2, tree.size());
        assertEquals(List.of(5, 8), tree.inOrder());
    }

    @Test
    void deleteNodeWithOnlyRightChild() {
        // Tree: root 5 with a right child 8 that has a right child 9.
        BinarySearchTree tree = treeWith(5, 8, 9);
        assertTrue(tree.delete(8));
        assertFalse(tree.contains(8));
        assertTrue(tree.contains(9)); // 9 promoted into 8's place
        assertEquals(2, tree.size());
        assertEquals(List.of(5, 9), tree.inOrder());
    }

    @Test
    void deleteNodeWithOnlyLeftChild() {
        // Tree: root 5 with a left child 3 that has a left child 1.
        BinarySearchTree tree = treeWith(5, 3, 1);
        assertTrue(tree.delete(3));
        assertFalse(tree.contains(3));
        assertTrue(tree.contains(1)); // 1 promoted into 3's place
        assertEquals(2, tree.size());
        assertEquals(List.of(1, 5), tree.inOrder());
    }

    @Test
    void deleteRootWithTwoChildrenUsesSuccessor() {
        // Tree:     50
        //         /    \
        //        30     70
        //       /  \   /  \
        //      20  40 60  80
        BinarySearchTree tree = treeWith(50, 30, 70, 20, 40, 60, 80);
        assertTrue(tree.delete(50)); // successor is 60
        assertFalse(tree.contains(50));
        assertEquals(6, tree.size());
        assertEquals(List.of(20, 30, 40, 60, 70, 80), tree.inOrder());
    }

    @Test
    void deleteMissingValueReturnsFalse() {
        BinarySearchTree tree = treeWith(5, 3, 8);
        assertFalse(tree.delete(99));
        assertEquals(3, tree.size());
        assertFalse(tree.delete(4));
    }

    @Test
    void deleteDownToEmptyTree() {
        BinarySearchTree tree = treeWith(5, 3);
        assertTrue(tree.delete(5));
        assertTrue(tree.delete(3));
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
    }

    @Test
    void preOrderVisitsRootThenChildren() {
        BinarySearchTree tree = treeWith(50, 30, 70, 20, 40, 60, 80);
        assertEquals(List.of(50, 30, 20, 40, 70, 60, 80), tree.preOrder());
    }

    @Test
    void postOrderVisitsChildrenThenRoot() {
        BinarySearchTree tree = treeWith(50, 30, 70, 20, 40, 60, 80);
        assertEquals(List.of(20, 40, 30, 60, 80, 70, 50), tree.postOrder());
    }

    @Test
    void traversalsOfSingleNodeTree() {
        BinarySearchTree tree = treeWith(42);
        assertEquals(List.of(42), tree.inOrder());
        assertEquals(List.of(42), tree.preOrder());
        assertEquals(List.of(42), tree.postOrder());
    }
}
