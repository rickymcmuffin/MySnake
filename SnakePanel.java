import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class SnakePanel extends JPanel {

	public static final int HEIGHT = 500;
	public static final int WIDTH = 500;

	
	private Timer timer;
	Space[][] board;


	// creates a new board with specified rows and columns
	public SnakePanel(Space[][] board) {
		this.setLayout(new GridLayout(board.length, board[0].length));
		this.setFocusable(true);
		this.setSize(HEIGHT, WIDTH);

		this.board = board;	
		System.out.println("huh?");
		updateBoard(board);

	}

	public void startTimer(){

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
			
		};
		timer = new Timer(30, action);

		timer.start();


	}

	// updates board with new game position
	// 1 is snake. 0 is no snake
	public void updateBoard(Space[][] board) {
		this.board = board;

		// for (int i = 0; i < board.length; i++) {
		// 	for (int j = 0; j < board[0].length; j++) {
		// 		if(board[i][j] == Space.BODY){
		// 			this.board[i][j].setBackground(Color.BLACK);
		// 		} else if (board[i][j] == Space.APPLE){
		// 			this.board[i][j].setBackground(Color.RED);
		// 		} else {
		// 			this.board[i][j].setBackground(Color.WHITE);
		// 		}
		// 	}
		// }

	}

	public void paint(Graphics g){
		int xLen = HEIGHT / board.length;
		int yLen = WIDTH / board[0].length;

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				g.drawString(i + ", " + j, i*xLen, j*yLen);
				g.setColor(Color.WHITE);
				g.drawRect(i*xLen, j*yLen, xLen, yLen);

				if(board[j][i] == Space.EMPTY){
					g.setColor(Color.BLACK);
				}
				else if(board[j][i] == Space.BODY){
					g.setColor(Color.YELLOW);
				}	
				else if(board[j][i] == Space.APPLE){
					g.setColor(Color.RED);
				}	
				g.fillRect(i*xLen, j*yLen, xLen, yLen);

				g.setColor(Color.WHITE);
				g.drawRect(i*xLen, j*yLen, xLen, yLen);
			}
			
		}


	}



}
