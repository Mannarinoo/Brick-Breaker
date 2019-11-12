import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;




public class MainPanel extends JPanel
{
	//Instance Variables
	
	private ControlPanel controlPanel;
	private BrickPanel BrickPanel;
	private MainMenu MainMenu;
	private Holder _holder;
	public String _gameState = "MainMenu";
	private Image _brickbackground;
	private Font _myFont;
	private PaddleShape _paddle1;
    private PaddleShape _paddle2;
   
	//Constructor- Creates the Brick and ControlPanel's and sets their layouts 
	public MainPanel()
	{
		super();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
		_brickbackground = new ImageIcon("brickbackground.jpg").getImage();
		
        
		_paddle2 = new PaddleShape();
		_paddle1 = new PaddleShape();
        
	
		 
		
		
		Holder _holder = new Holder(BrickPanel);
		
		BrickPanel = new BrickPanel(_holder, _paddle1, _paddle2, controlPanel, this);
		
		MainMenu = new MainMenu(this);
		MainMenu.setLayout(new BoxLayout(MainMenu, BoxLayout.Y_AXIS));
		MainMenu.setPreferredSize(new Dimension(800, 450));
		MainMenu.setMaximumSize(new Dimension(800, 450));
		
		controlPanel = new ControlPanel(BrickPanel, this, _holder, _paddle1, _paddle2, MainMenu);
		controlPanel.setLayout(new GridLayout(1,5));
		controlPanel.setPreferredSize(new Dimension(800, 65));
		controlPanel.setMaximumSize(new Dimension(800, 65));
		
		
		
		
		
		
		this.add(BrickPanel); 
		this.add(controlPanel); 
		this.add(MainMenu);
		
		controlPanel.setVisible(false);
		BrickPanel.setVisible(false);
		MainMenu.setVisible(true);
		MyClickListener listener = new MyClickListener(this, BrickPanel, _holder);
		this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
        this.addKeyListener(listener);
		this.setFocusable(true);
		
		//create a button instead of the play rectangle !!!!!!!!!!!!!!!!
		
		
		
	}
	//Moves the ball and calls the reset methods if the game is won or lost
	public void moveBall() {
		if (BrickPanel.getBrickCount() == -1) {
			
    		controlPanel.resetGame();
    		controlPanel.gameWonText();
    	}
		if (BrickPanel.getBallShape().getY() >= 300) {
			 
			controlPanel.resetGame();
			 controlPanel.gameOverText();
			 
			}
		//calls the moveBall method to move the ball
		BrickPanel.moveBall();
	}
	//resets the balls location and paint it on the panel
	public void resetGame() {
		BrickPanel.resetBallLocation();
		BrickPanel.repaint();
	}
	public void setGameState(String i) {
		_gameState = i;
	}
	public void setControlsinvis(boolean f) {
		controlPanel.setVisible(f);
	}
	 public void paintComponent(java.awt.Graphics aBrush)
	    {
		 super.paintComponent(aBrush);
		 aBrush.drawImage(_brickbackground, 0, 0, 800, 450, null);
		
	        aBrush.setColor(Color.black);
	        aBrush.fillRect(70, 150, 220, 120);
	        aBrush.setColor(new Color(255,102,0));
	        aBrush.fillRect(80, 160, 200, 100);
	        aBrush.setColor(Color.black);
	        aBrush.setFont(new Font("Serif", Font.BOLD, 40));
	        aBrush.drawString("EASY", 125, 220);
	        
	        aBrush.fillRect(290, 150, 220, 120);
	        aBrush.setColor(new Color(255,102,0));
	        aBrush.fillRect(300, 160, 200, 100);
	        aBrush.setColor(Color.black);
	        aBrush.setFont(new Font("Serif", Font.BOLD, 40));
	        aBrush.drawString("MEDIUM", 310, 220);
	        
	        aBrush.fillRect(510, 150, 220, 120);
	        aBrush.setColor(new Color(255,102,0));
	        aBrush.fillRect(520, 160, 200, 100);
	        aBrush.setColor(Color.black);
	        aBrush.setFont(new Font("Serif", Font.BOLD, 40));
	        aBrush.drawString("HARD", 565, 220);
		 
		
	        }
	 
	 private class MyClickListener implements MouseListener, MouseMotionListener, KeyListener, ActionListener
	 {
	 	
	 	
	 	private MainPanel _mainPanel;
	 	private BrickPanel _bp;
	 	private Holder _holder;
	 	java.awt.Point lastMousePosition;
	 	int mx;
	 	int my;
	 	public MyClickListener(MainPanel mainPanel, BrickPanel bp, Holder holder)
	 	{
	 		_mainPanel = mainPanel;
	 		_holder = holder;
	 		_bp = bp;
	 }

	 	public void mouseClicked (java.awt.event.MouseEvent e){}
	 	//When the paddle is pressed the mouse location is saved and the 
	 	//state is set.
	 	
	 	public void mousePressed(MouseEvent e) {
	 		int mx = (int) (e.getX());
			int my = (int) (e.getY());
			
	    if (_gameState == "Difficulty") {
	    	if (mouseOver(mx, my, 80, 160, 200, 100)) {
	    		_holder.setBallSpeed(6);
	    		_holder.setBrickCount(2);
				
				controlPanel.setVisible(true);
	    		BrickPanel.setVisible(true);
	    		_gameState = "Play";
	    		System.out.println("easy");
	    		_bp.requestFocusInWindow();
	    		BrickPanel.repaint();
	    	}
	    		
	    	if (mouseOver(mx, my, 300, 160, 200, 100 )) {
	    		_holder.setBallSpeed(9);
	    		_holder.setBrickCount(3);
				
				controlPanel.setVisible(true);
	    		BrickPanel.setVisible(true);
	    		_gameState = "Play";
	    		System.out.println("medium");
	    		_bp.requestFocusInWindow();
	    	}
	    	
	    	if (mouseOver(mx, my, 520, 160, 200, 100)) {
	    		_holder.setBallSpeed(12);
	    		_holder.setBrickCount(5);
				
				controlPanel.setVisible(true);
	    		BrickPanel.setVisible(true);
	    		_gameState = "Play";
	    		System.out.println("hard");
	    		_bp.requestFocusInWindow();
	    	}
	    }
	 }
	 	
	 	public void keyPressed(KeyEvent e) {
	 		if (e.getKeyCode()== 83) {
				_gameState = "Shop";
				_mainPanel.repaint();
				System.out.println("hey");
				
				
			}
	 		
	 		 
	 	}
	 	public void mouseDragged(MouseEvent e) {
	 		//If the mouse presses the paddles the paddle will move with the mouse
	 		
	 	}

	 	public void mouseReleased(MouseEvent e) {}

	 	public void mouseEntered(MouseEvent e) {}

	 	public void mouseExited(MouseEvent e) {}

	 	@Override
	 	public void keyReleased(KeyEvent arg0) {}

	 	@Override
	 	public void keyTyped(KeyEvent arg0) {}

	 	public void mouseMoved(MouseEvent arg0) {}
	 	
	 	@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	 	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
			if (mx > x && mx < x + width) {
				if (my > y && my < y + height) {
					return true;
				} else
					return false;
			} else
				return false;
		}

		
	 	}
	
}
