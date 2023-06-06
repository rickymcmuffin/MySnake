import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements KeyListener{
	SnakePanel gamePanel;

	public GameFrame(){
		gamePanel = new SnakePanel(20, 20);
		gamePanel.setSize(400, 400);
		this.add(gamePanel);

		addKeyListener(this);
		setFocusable(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed " + e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			gamePanel.move(Direction.LEFT);
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			gamePanel.move(Direction.RIGHT);
		} else if(e.getKeyCode() == KeyEvent.VK_UP){
			gamePanel.move(Direction.UP);
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			gamePanel.move(Direction.DOWN);
		} 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Released " + e.getKeyChar());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Typed " + e.getKeyChar());
	}
}
