import java.util.ArrayDeque;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {

	Direction direction;

	Snake snake;
	Point apple;

	Space[][] board;

	boolean running;

	public Game(int rows, int cols) {
		snake = new Snake(rows / 2, cols / 2);
		direction = Direction.RIGHT;

		board = new Space[rows][cols];

	}

	public Snake getSnake() {
		return snake;
	}

	public void playGame() {

	}

	public void changeDirection(Direction d) {
		direction = d;

		running = move();
	}

	private boolean move() {

		snake.move(direction, true);

		if (snake.getFirst().x < 0
				|| snake.getFirst().y < 0
				|| snake.getFirst().x >= board.length
				|| snake.getFirst().y >= board[0].length) {

			return false;
		}

		return true;
	}

}