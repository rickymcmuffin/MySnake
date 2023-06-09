import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Snake");



		// JFrame fr = new JFrame();
		// fr.setSize(500, 500);
		// fr.setVisible(true);

		GameFrame frame = new GameFrame();
		
		frame.setVisible(true);

		frame.setSize(500, 500);
	}

}