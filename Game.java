import java.util.ArrayDeque;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

	SnakePanel pane;

	Direction direction;

	Snake snake;
	Point apple;

	Space[][] board;

	boolean running;

	boolean extending;

	public Game(int rows, int cols) {
		snake = new Snake(rows / 2, cols / 2);
		apple = new Point(rows / 2, cols / 2);
		direction = Direction.LEFT;

		board = new Space[rows][cols];
		updateBoard();
		updateApple();
		updateBoard();

		pane = new SnakePanel(board);

		extending = false;

	}

	public Snake getSnake() {
		return snake;
	}

	public SnakePanel getPanel() {
		return pane;
	}

	public void playGame() {

	}

	public void setDirection(Direction d) {
		direction = d;

		running = move();
		System.out.println(running);

		pane.updateBoard(board);
	}

	private boolean move() {

		snake.move(direction, extending);

		int x = snake.getFirst().x;
		int y = snake.getFirst().y;

		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length
				|| board[x][y] != Space.BODY) {

			return false;
		}

		if (board[x][y] == Space.APPLE) {
			updateApple();
			extending = true;
		}

		updateBoard();
		return true;
	}

	// puts apple in new position if it has been eaten
	private void updateApple() {
		while (board[apple.x][apple.y] != Space.BODY) {
			int randomX = ThreadLocalRandom.current().nextInt(0, board.length - 1);
			int randomY = ThreadLocalRandom.current().nextInt(0, board[0].length - 1);
			apple.setLocation(randomX, randomY);
		}
	}

	private void updateBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = Space.EMPTY;
			}
		}
		Iterator<Point> itr = snake.iterator();

		while (itr.hasNext()) {
			Point p = itr.next();
			board[p.x][p.y] = Space.BODY;

		}

		board[apple.x][apple.y] = Space.APPLE;

		if (pane == null) {
			System.out.println("brethern");
		}
	}

}