import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
    private final int GRID_SIZE = 10;
    private MyArrayListHM<Point> snake;
    private Point food;
    private int score;
    private String direction;
    private Random rand;
    private Scanner input;

    public SnakeGame() {
        snake = new MyArrayListHM<>();
        rand = new Random();
        input = new Scanner(System.in);
        resetGame();
    }

    private void resetGame() {
        snake.clear();
        snake.add(0, new Point(GRID_SIZE / 2, GRID_SIZE / 2));
        score = 0;
        direction = "W"; // start going up
        spawnFood();
    }

    private void spawnFood() {
        while (true) {
            int fx = rand.nextInt(GRID_SIZE);
            int fy = rand.nextInt(GRID_SIZE);
            Point newFood = new Point(fx, fy);
            if (!snake.contains(newFood)) {
                food = newFood;
                break;
            }
        }
    }

    private void drawGrid() {
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                Point p = new Point(x, y);
                if (p.equals(snake.get(0))) {
                    System.out.print("H ");
                } else if (snake.contains(p)) {
                    System.out.print("b ");
                } else if (p.equals(food)) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("Score: " + score);
    }

    private void updateDirection() {
        System.out.print("Enter direction (WASD): ");
        String d = input.nextLine().toUpperCase();
        if (d.equals("W") || d.equals("A") || d.equals("S") || d.equals("D")) {
            direction = d;
        }
    }

    private void moveSnake() {
        Point head = snake.get(0);
        int newX = head.x;
        int newY = head.y;

        switch (direction) {
            case "W": newY--; break;
            case "S": newY++; break;
            case "A": newX--; break;
            case "D": newX++; break;
        }

        // Wrapping logic
        if (newX < 0) newX = GRID_SIZE - 1;
        if (newX >= GRID_SIZE) newX = 0;
        if (newY < 0) newY = GRID_SIZE - 1;
        if (newY >= GRID_SIZE) newY = 0;

        Point newHead = new Point(newX, newY);

        // Collision with self
        if (snake.contains(newHead)) {
            gameOver();
            return;
        }

        // Add head
        snake.add(0, newHead);

        // Check food
        if (newHead.equals(food)) {
            score++;
            spawnFood();
        } else {
            snake.remove(snake.getSize() - 1);
        }
    }

    private void gameOver() {
        System.out.println("Game Over! Final Length: " + snake.getSize() + ", Score: " + score);
        System.out.print("Play again? (Y/N): ");
        String ans = input.nextLine().toUpperCase();
        if (ans.equals("Y")) {
            resetGame();
        } else {
            System.exit(0);
        }
    }

    public void start() {
        while (true) {
            drawGrid();
            updateDirection();
            moveSnake();
        }
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        game.start();
    }
}
