import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;



public class MainMenu extends JPanel {
	private JButton _play;
    private JButton _help;
    private Image _brickbackground;
    private MainPanel _mp;
    
	public MainMenu(MainPanel mp) {
		
		_mp = mp;
		_brickbackground = new ImageIcon("brickbackground.jpg").getImage();
		
		
		_play = new JButton("Play");
		_play.setForeground(Color.BLACK);
		_play.setFont(new Font("Serif", Font.BOLD, 40));
		_play.setBackground(new Color(255,102,0));
		_play.setPreferredSize(new Dimension(200, 100));
		_play.setMaximumSize(new Dimension(200, 100));
		_play.setAlignmentX(CENTER_ALIGNMENT);
		_play.setAlignmentY(CENTER_ALIGNMENT);
		
	
		
		_help = new JButton("Help");
		_help.setForeground(Color.BLACK);
		_help.setFont(new Font("Serif", Font.BOLD, 40));
		_help.setBackground(new Color(255,102,0));
		_help.setPreferredSize(new Dimension(200, 100));
		_help.setMaximumSize(new Dimension(200, 100));
		_help.setAlignmentX(CENTER_ALIGNMENT);
		_help.setAlignmentY(CENTER_ALIGNMENT);
		
		MyClickListener Button1Listener = new MyClickListener(this, 0, _mp);
		MyClickListener Button2Listener = new MyClickListener(this, 1, _mp);
		
		
		MyClickListener listener = new MyClickListener(this, 5, _mp);
		
		Dimension panelSize = new Dimension(100, 65);
		this.setPreferredSize(panelSize);
		this.setBackground(Color.black);
        
        _play.addActionListener(Button1Listener);
		_help.addActionListener(Button2Listener);
		
		
		Dimension minSize = new Dimension(5, 85);
		Dimension prefSize = new Dimension(5, 85);
		Dimension maxSize = new Dimension(Short.MAX_VALUE, 85);
		this.add(new Box.Filler(minSize, prefSize, maxSize));
		this.add(_play);
		Dimension minSize2 = new Dimension(5, 40);
		Dimension prefSize2 = new Dimension(5, 40);
		Dimension maxSize2 = new Dimension(Short.MAX_VALUE, 40);
		this.add(new Box.Filler(minSize2, prefSize2, maxSize2));
		this.add(_help);
		this.setVisible(false);
	}
	 public void paintComponent(java.awt.Graphics aBrush)
	    {
		 super.paintComponent(aBrush);
		 
		 aBrush.drawImage(_brickbackground, 0, 0, 800, 450, null);
		 aBrush.setColor(Color.black);
		 aBrush.fillRect(283, 77, 220, 120);
		 aBrush.fillRect(283, 215, 220, 120);
		/*
			 
	          aBrush.drawImage(_brickbackground, 0, 0, 800, 450, null);
	   //     aBrush.setColor(Color.black);
	   //     aBrush.fillRect(290, 100, 220, 120);
	   //     aBrush.setColor(new Color(255,102,0));
	   //     aBrush.fillRect(300, 110, 200, 50);
	   //     aBrush.setColor(Color.black);
	   //     aBrush.setFont(new Font("Serif", Font.BOLD, 40));
	   //     aBrush.drawString("Play", 365, 170);
	        
	        aBrush.fillRect(290, 230, 220, 120);
	        aBrush.setColor(new Color(255,102,0));
	        aBrush.fillRect(300, 240, 200, 100);
	        aBrush.setColor(Color.black);
	        aBrush.setFont(new Font("Serif", Font.BOLD, 40));
	        aBrush.drawString("Help", 365, 300);
	        
	        aBrush.fillRect(290, 280, 220, 120);
	        aBrush.setColor(new Color(255,102,0));
	        aBrush.fillRect(300, 290, 200, 100);
	        aBrush.setColor(Color.black);
	        aBrush.setFont(new Font("Serif", Font.BOLD, 40));
	        aBrush.drawString("Shop", 365, 350);
	        
		 
	
			 aBrush.drawImage(_brickbackground, 0, 0, 800, 450, null);
			 aBrush.fillRect(150, 20, 500, 380);
			 
			 
		 
		/* if (_gameState == "Shop") {
			 aBrush.setColor(Color.black);
			 aBrush.fillRect(0, 0, 800, 450);
			 aBrush.setColor(new Color(255,102,0));
			 aBrush.fillRect(20, 20, 760, 410);
			 aBrush.setColor(Color.black);
			 aBrush.drawRect(40, 40, 50, 50);
			 aBrush.setColor(Color.white);
			 aBrush.drawString("COINS = " + BrickPanel.getScore(), 40, 15);
			 
			 
			 
		 }
		 
		
			 
		 */
	        }
}
class MyClickListener implements ActionListener
{
	MainMenu _mm;
	int _button;
	MainPanel _mp;
	public MyClickListener(MainMenu mm, int button, MainPanel mp) {
		_mm = mm;
		_button = button;
		_mp = mp;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//Make it so when the play button is clicked it switches to picking the difficulty of the game
		if (_button == 0) {
			_mm.setVisible(false);
			_mp.setGameState("Difficulty");
		}
		if (_button == 1) {
			
		}
	}
	
}

