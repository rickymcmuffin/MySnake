import javax.swing.JFrame;

public class gameFrame extends JFrame {
	
	public gameFrame(){
		snakePanel gamePanel = new snakePanel(20, 20);

		this.add(gamePanel);


	}
}
