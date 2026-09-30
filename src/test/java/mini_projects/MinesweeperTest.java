package mini_projects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinesweeperTest {

    // Layout:  M . M
    //          . . .
    //          . . .
    private Minesweeper fixedBoard() {
        boolean[][] mines = {
            {true, false, true},
            {false, false, false},
            {false, false, false}
        };
        return new Minesweeper(mines);
    }

    @Test
    void neighbourMineCountsAreCorrect() {
        Minesweeper board = fixedBoard();
        assertEquals(2, board.neighbourMineCount(0, 1));
        assertEquals(1, board.neighbourMineCount(1, 0));
        assertEquals(2, board.neighbourMineCount(1, 1));
        assertEquals(1, board.neighbourMineCount(1, 2));
        assertEquals(0, board.neighbourMineCount(2, 0));
        assertEquals(0, board.neighbourMineCount(2, 1));
        assertEquals(0, board.neighbourMineCount(2, 2));
    }

    @Test
    void revealingAMineReturnsFalse() {
        Minesweeper board = fixedBoard();
        assertFalse(board.reveal(0, 0));
        assertTrue(board.isRevealed(0, 0));
    }

    @Test
    void revealingEmptyCellReturnsTrue() {
        Minesweeper board = fixedBoard();
        assertTrue(board.reveal(2, 2));
    }

    @Test
    void floodFillOpensEveryConnectedEmptyCell() {
        Minesweeper board = fixedBoard();
        board.reveal(2, 2);

        // The whole empty region opens...
        assertTrue(board.isRevealed(2, 2));
        assertTrue(board.isRevealed(2, 1));
        assertTrue(board.isRevealed(2, 0));
        assertTrue(board.isRevealed(1, 0));
        assertTrue(board.isRevealed(1, 1));
        assertTrue(board.isRevealed(1, 2));
    }

    @Test
    void floodFillStopsAtTheNumberedBorder() {
        Minesweeper board = fixedBoard();
        board.reveal(2, 2);

        // ...but stops at the numbered cell and never touches the mines.
        assertFalse(board.isRevealed(0, 1));
        assertFalse(board.isRevealed(0, 0));
        assertFalse(board.isRevealed(0, 2));
    }

    @Test
    void revealingANumberedCellDoesNotSpread() {
        Minesweeper board = fixedBoard();
        board.reveal(1, 0);   // has 1 neighbour mine

        assertTrue(board.isRevealed(1, 0));
        assertFalse(board.isRevealed(0, 0));
        assertFalse(board.isRevealed(1, 1));
        assertFalse(board.isRevealed(2, 0));
    }

    @Test
    void hasWonIsTrueWhenEverySafeCellIsRevealed() {
        Minesweeper board = fixedBoard();
        int[] safeCells = {0, 1, 1, 0, 1, 1, 1, 2, 2, 0, 2, 1, 2, 2};
        for (int i = 0; i < safeCells.length; i += 2) {
            board.reveal(safeCells[i], safeCells[i + 1]);
        }
        assertTrue(board.hasWon());
        assertFalse(board.isRevealed(0, 0));   // the mines themselves stay hidden
    }

    @Test
    void revealingTheSameCellTwiceIsHarmless() {
        Minesweeper board = fixedBoard();
        board.reveal(2, 2);
        assertTrue(board.reveal(2, 2));   // already revealed, still returns true
        assertEquals(6, countRevealed(board));
    }

    private int countRevealed(Minesweeper board) {
        int count = 0;
        for (int row = 0; row < board.rows(); row++) {
            for (int col = 0; col < board.cols(); col++) {
                if (board.isRevealed(row, col)) {
                    count++;
                }
            }
        }
        return count;
    }
}
