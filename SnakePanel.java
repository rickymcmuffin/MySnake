import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Iterator;

import javax.swing.*;

public class SnakePanel extends JPanel {
	JLabel board[][];


	// creates a new board with specified rows and columns
	public SnakePanel(Space[][] board) {
		this.setLayout(new GridLayout(board.length, board[0].length));
		this.setFocusable(true);

		this.board = new JLabel[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				this.board[i][j] = new JLabel();
				this.board[i][j].setOpaque(true);
				this.board[i][j].setText(i + ", " + j);
				this.add(this.board[i][j]);
			}
		}
		System.out.println("huh?");
		updateBoard(board);

	}

	// updates board with new game position
	// 1 is snake. 0 is no snake
	public void updateBoard(Space[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] == Space.BODY){
					this.board[i][j].setBackground(Color.BLACK);
				} else if (board[i][j] == Space.APPLE){
					this.board[i][j].setBackground(Color.RED);
				} else {
					this.board[i][j].setBackground(Color.WHITE);
				}
			}
		}

	}


}
