import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Iterator;

import javax.swing.*;

public class SnakePanel extends JPanel {
	JLabel board[][];

	Game game;

	// creates a new board with specified rows and columns
	public SnakePanel(int rows, int cols) {
		this.setLayout(new GridLayout(rows, cols));
		this.setFocusable(true);

		board = new JLabel[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new JLabel();
				board[i][j].setBackground(Color.BLACK);
				board[i][j].setOpaque(true);
				board[i][j].setText(i + ", " + j);
				this.add(board[i][j]);
			}
		}
		game = new Game(rows, cols);

		updateBoard(game.getSnake());

	}

	// updates board with new game position
	// 1 is snake. 0 is no snake
	public void updateBoard(ArrayDeque<Point> snake) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j].setBackground(Color.BLACK);
			}
		}
		Iterator<Point> itr = snake.iterator();

		while (itr.hasNext()) {
			Point p = itr.next();
			board[p.x][p.y].setBackground(Color.WHITE);

		}

	}

	public void move(Direction d) {
		System.out.println("bruh");
		game.changeDirection(d);
		System.out.println(game.getSnake());

		if (game.running) {
			updateBoard(game.getSnake());
		} else {
			JOptionPane.showMessageDialog(null, "YOU LOST");
			System.exit(0);
		}
	}

}
