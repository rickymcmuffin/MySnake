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
		generateGame(rows, cols);
		pane = new SnakePanel(board);

	}

	private void generateGame(int rows, int cols) {
		board = new Space[rows][cols];

		direction = Direction.LEFT;
		snake = new Snake(rows / 2, cols / 2);

		extending = false;
		do {
			int randomX = ThreadLocalRandom.current().nextInt(0, board.length - 1);
			int randomY = ThreadLocalRandom.current().nextInt(0, board[0].length - 1);
			apple = new Point(randomX, randomY);
		} while (apple.equals(snake.getFirst()));

		updateBoard();
	}

	public Snake getSnake() {
		return snake;
	}

	public SnakePanel getPanel() {
		return pane;
	}

	public boolean isRunning() {
		return running;
	}

	public void startGame() {
		System.out.println("Game starting...");

		running = true;
		while (running) {
			try {
				Thread.sleep(100);
				running = move();
				pane.updateBoard(board);
			} catch (Exception e) {
				System.out.println("Ah rip");
			}
		}
	}

	public void setDirection(Direction d) {
		if (Math.abs(d.getValue() - direction.getValue()) != 2) {
			direction = d;
		}
		running = move();
		pane.updateBoard(board);

	}

	private boolean move() {

		snake.move(direction, extending);
		extending = false;

		int x = snake.getFirst().x;
		int y = snake.getFirst().y;

		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length
				|| board[x][y] == Space.BODY) {

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
		do {
			int randomX = ThreadLocalRandom.current().nextInt(0, board.length - 1);
			int randomY = ThreadLocalRandom.current().nextInt(0, board[0].length - 1);
			apple.setLocation(randomX, randomY);
		} while (board[apple.x][apple.y] == Space.BODY);
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