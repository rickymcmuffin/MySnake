import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements KeyListener{
	Game game;

	public GameFrame(){
		game = new Game(10, 10);
		SnakePanel pane = game.getPanel();
		pane.setSize(400, 400);
		this.add(pane);




		addKeyListener(this);
		setFocusable(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Snake");



	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed " + e.getKeyCode());

		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			game.setDirection(Direction.LEFT);
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			game.setDirection(Direction.RIGHT);
		} else if(e.getKeyCode() == KeyEvent.VK_UP){
			game.setDirection(Direction.UP);
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			game.setDirection(Direction.DOWN);
		} 

		game.startGame();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Released " + e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Typed " + e.getKeyCode());
	}
}
