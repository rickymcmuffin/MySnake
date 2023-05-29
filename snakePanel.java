import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class snakePanel extends JPanel {
	JLabel spaces[][];

	// creates a new board with specified rows and columns
	public snakePanel(int rows, int cols){
		this.setLayout(new GridLayout(rows, cols));

		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				spaces[i][j] = new JLabel();
				spaces[i][j].setBackground(Color.BLACK);
				this.add(spaces[i][j]);
			}
		}



	}

	// updates board with new game position
	// 1 is snake. 0 is no snake
	public void updateBoard(boolean[][] board){

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){

				if(board[i][j] == true){
					spaces[i][j].setBackground(Color.BLACK);
				} else {
					spaces[i][j].setBackground(Color.WHITE);
				}

			}
		}
	}
	
}
