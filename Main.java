import javax.swing.JFrame;

public class Main {
/*
 * Main Class 
 * Provides the frame that the game is built on
 */
	public static void main(String[] args) {
		JFrame obj = new JFrame();
		Gameplay gameplay = new Gameplay();
		obj.setBounds(600,200,550,630);
		obj.setTitle("2048");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameplay);
	}
}
