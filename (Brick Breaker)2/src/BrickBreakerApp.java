import java.awt.GridLayout;

/**
 * Joey Mannarino
 * 4/21/2018
 * Lab 12
 *
 * Chapter 7: BallApp.java Displays a blank window.
 */
public class BrickBreakerApp extends javax.swing.JFrame {
	public BrickBreakerApp(String title) {
		super(title);
		this.setSize(800, 450);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.add(new MainPanel());
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		BrickBreakerApp app = new BrickBreakerApp("BRICK BREAKER");
	}
}
