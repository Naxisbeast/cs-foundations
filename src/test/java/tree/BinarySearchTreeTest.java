package tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void newTreeIsEmptyWithSizeZero() {
        BinarySearchTree tree = new BinarySearchTree();
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertEquals(-1, tree.height());
    }

    @Test
    void insertRootAndContains() {
        BinarySearchTree tree = new BinarySearchTree();
        assertTrue(tree.insert(5));
        assertTrue(tree.contains(5));
        assertFalse(tree.contains(3));
        assertEquals(1, tree.size());
        assertEquals(0, tree.height());
    }

    @Test
    void insertLeftAndRightChildren() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(8));
        assertEquals(3, tree.size());
        assertEquals(1, tree.height());
    }

    @Test
    void duplicateInsertIsIgnored() {
        BinarySearchTree tree = new BinarySearchTree();
        assertTrue(tree.insert(5));
        assertFalse(tree.insert(5));
        assertEquals(1, tree.size());
    }

    @Test
    void inOrderReturnsAscendingOrder() {
        BinarySearchTree tree = new BinarySearchTree();
        for (int value : new int[]{50, 30, 70, 20, 40, 60, 80}) {
            tree.insert(value);
        }
        assertEquals(List.of(20, 30, 40, 50, 60, 70, 80), tree.inOrder());
    }

    @Test
    void minAndMax() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        assertEquals(30, tree.min());
        assertEquals(70, tree.max());
    }

    @Test
    void minAndMaxOnEmptyTreeThrow() {
        BinarySearchTree tree = new BinarySearchTree();
        assertThrows(IllegalStateException.class, tree::min);
        assertThrows(IllegalStateException.class, tree::max);
    }

    @Test
    void heightOfSkewedTreeIsNumberOfEdges() {
        BinarySearchTree tree = new BinarySearchTree();
        for (int value : new int[]{1, 2, 3, 4}) {
            tree.insert(value);
        }
        assertEquals(3, tree.height());
        assertEquals(4, tree.size());
    }

    @Test
    void containsMissingValueReturnsFalse() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        assertFalse(tree.contains(7));
        assertFalse(tree.contains(0));
        assertFalse(tree.contains(100));
    }
}
