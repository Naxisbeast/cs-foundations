package mini_projects;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Text-based Minesweeper. The interesting part is the reveal():
 * uncovering an empty cell opens every connected empty cell too - a
 * flood-fill that is BFS in disguise, spreading through the grid with a
 * queue. That is the same graph traversal from data-structures/graph/,
 * hiding inside a game.
 */
public class Minesweeper {

    private final int rows;
    private final int cols;
    private final boolean[][] mines;
    private final boolean[][] revealed;
    private final int[][] neighbourMineCounts;

    /** Build from a fixed mine layout - used by tests and by placeMines. */
    public Minesweeper(boolean[][] mines) {
        this.mines = mines;
        this.rows = mines.length;
        this.cols = mines[0].length;
        this.revealed = new boolean[rows][cols];
        this.neighbourMineCounts = countNeighbourMines();
    }

    /** Build a randomly-mined board of the given size. */
    public Minesweeper(int rows, int cols, int mineCount) {
        this(placeMines(rows, cols, mineCount));
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    public boolean isMine(int row, int col) {
        return mines[row][col];
    }

    public boolean isRevealed(int row, int col) {
        return revealed[row][col];
    }

    public int neighbourMineCount(int row, int col) {
        return neighbourMineCounts[row][col];
    }

    /** Reveal a cell. Returns false if it was a mine (game over). */
    public boolean reveal(int row, int col) {
        if (mines[row][col]) {
            revealed[row][col] = true;
            return false;
        }
        floodFill(row, col);
        return true;
    }

    /** True when every non-mine cell has been revealed. */
    public boolean hasWon() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!mines[row][col] && !revealed[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    /** Flood-fill (BFS): a zero-cell opens, then spreads to neighbours until it hits the numbered border. */
    private void floodFill(int startRow, int startCol) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        revealed[startRow][startCol] = true;
        queue.add(new int[]{startRow, startCol});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            if (neighbourMineCounts[cell[0]][cell[1]] != 0) {
                continue;   // numbered cell: opened, but does not spread
            }
            for (int[] neighbour : neighbours(cell[0], cell[1])) {
                int row = neighbour[0];
                int col = neighbour[1];
                if (!revealed[row][col] && !mines[row][col]) {
                    revealed[row][col] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    private int[][] countNeighbourMines() {
        int[][] counts = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int[] neighbour : neighbours(row, col)) {
                    if (mines[neighbour[0]][neighbour[1]]) {
                        counts[row][col]++;
                    }
                }
            }
        }
        return counts;
    }

    private List<int[]> neighbours(int row, int col) {
        List<int[]> result = new ArrayList<>();
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) {
                    continue;
                }
                int nr = row + dr;
                int nc = col + dc;
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    result.add(new int[]{nr, nc});
                }
            }
        }
        return result;
    }

    private static boolean[][] placeMines(int rows, int cols, int mineCount) {
        boolean[][] mines = new boolean[rows][cols];
        Random random = new Random();
        int placed = 0;
        while (placed < mineCount) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            if (!mines[row][col]) {
                mines[row][col] = true;
                placed++;
            }
        }
        return mines;
    }

    public void printBoard() {
        System.out.print("   ");
        for (int col = 0; col < cols; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        for (int row = 0; row < rows; row++) {
            System.out.print(row + "  ");
            for (int col = 0; col < cols; col++) {
                if (revealed[row][col]) {
                    if (mines[row][col]) {
                        System.out.print("* ");
                    } else {
                        System.out.print(neighbourMineCounts[row][col] + " ");
                    }
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Minesweeper game = new Minesweeper(8, 8, 10);
        System.out.println("Minesweeper - reveal cells, avoid the mines (8x8, 10 mines).");

        while (true) {
            game.printBoard();
            System.out.print("Enter 'row col' or 'q' to quit: ");
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("q")) {
                break;
            }
            String[] parts = line.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Enter two numbers: row col");
                continue;
            }
            try {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                if (row < 0 || row >= game.rows || col < 0 || col >= game.cols) {
                    System.out.println("Out of bounds.");
                    continue;
                }
                if (!game.reveal(row, col)) {
                    System.out.println("Boom! That was a mine. Game over.");
                    break;
                }
                if (game.hasWon()) {
                    System.out.println("You cleared the board - you win!");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter two numbers: row col");
            }
        }
        scanner.close();
    }
}
