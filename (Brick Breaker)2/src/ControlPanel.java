import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;


/*
 * Joey Mannarino
 * 4/10/2018
 * RadioButtonsPanel Class- Creates the Buttons and Listeners for buttons
 */
public class ControlPanel extends JPanel {
	//Instance Variables
	private JButton _startStop;
	private JButton _quit;
	private JButton _mainMenu;
	private Timer _timer;
	private BrickPanel _panel;
	private int i = 2;
	private JLabel _scorelabel;
	private JButton _resetGame;
	private int _score;
	private MainPanel _mainPanel;
	private Holder _holder;
	private PaddleShape _paddle1;
    private PaddleShape _paddle2;
    private MainMenu _mm;
	
	
	//Constructor - creates JRadioButtons, Jbuttons, Jlabels, Timer and listeners
	public ControlPanel(BrickPanel brickpanel, MainPanel mp, Holder holder, PaddleShape paddle1, PaddleShape paddle2, MainMenu mm) {
		_mainPanel = mp;
		_panel = brickpanel;
		_holder = holder;
		_paddle1 = paddle1;
		_paddle2 = paddle2;
		_mm = mm;
		
		
		
		//Creates buttons
		//JRadioButton buttonForEasy = new JRadioButton("Easy");
		//JRadioButton buttonForMedium = new JRadioButton("Medium");
		//JRadioButton buttonForHard = new JRadioButton("Hard");
		
		//JRadioButton buttonFor2rows = new JRadioButton("2 rows of bricks");
		//JRadioButton buttonFor3rows = new JRadioButton("3 rows of bricks");
		//JRadioButton buttonFor5rows = new JRadioButton("5 rows of bricks");
		
		_startStop = new JButton("Start");
		_startStop.setBackground(new Color(255,102,0));
		_quit = new JButton("Quit");
		_quit.setBackground(new Color(255,102,0));
		_mainMenu = new JButton("Main Menu");
		_mainMenu.setBackground(new Color(255,102,0));
		_resetGame = new JButton("Reset Game");
		_resetGame.setBackground(new Color(255,102,0));
		//sets resetGame label to invisible
		_resetGame.setVisible(false);
		//Creates JLabel
		_scorelabel = new JLabel("SCORE: " + _panel.getScore());
		_scorelabel.setBackground(java.awt.Color.WHITE);
		_scorelabel.setForeground(java.awt.Color.WHITE);
		_scorelabel.setFont(new Font("Serif", Font.BOLD, 20));
		_scorelabel.setHorizontalAlignment(JLabel.CENTER);
		//Creates listeners
		//RadioButtonListener EasyListener = new RadioButtonListener(1);
		//RadioButtonListener MediumListener = new RadioButtonListener(2);
		//RadioButtonListener HardListener = new RadioButtonListener(3);
		
		//RadioButtonListener tworowsListener = new RadioButtonListener(4);
		//RadioButtonListener threerowsListener = new RadioButtonListener(5);
		//RadioButtonListener fiverowsListener = new RadioButtonListener(6);

		ButtonListener Button1Listener = new ButtonListener(0, this, _mainPanel, _panel, _mm);
		ButtonListener Button2Listener = new ButtonListener(1, this, _mainPanel, _panel, _mm);
		ButtonListener Button3Listener = new ButtonListener(2, this, _mainPanel, _panel, _mm);
		
		//add action listeners to the buttons
		//buttonForEasy.addActionListener(EasyListener);
		//buttonForMedium.addActionListener(MediumListener);
		//buttonForHard.addActionListener(HardListener);
		
		//buttonFor2rows.addActionListener(tworowsListener);
		//buttonFor3rows.addActionListener(threerowsListener);
		//buttonFor5rows.addActionListener(fiverowsListener);
		
		_startStop.addActionListener(Button1Listener);
		_mainMenu.addActionListener(Button2Listener);
		_quit.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		_resetGame.addActionListener(Button3Listener);
		//create button group and add buttons to it
		//ButtonGroup buttonGroup = new ButtonGroup();
		//buttonGroup.add(buttonForEasy);
		//buttonGroup.add(buttonForMedium);
		//buttonGroup.add(buttonForHard);
		
		//ButtonGroup buttonGroup2 = new ButtonGroup();
		//buttonGroup2.add(buttonFor2rows);
		//buttonGroup2.add(buttonFor3rows);
		//buttonGroup2.add(buttonFor5rows);
		
		Dimension panelSize = new Dimension(100, 65);
		this.setPreferredSize(panelSize);
		this.setBackground(Color.black);
		//this.setFocusable(false);
		
		
		//Create Timer and add Listener
		_timer = new Timer(100, null);
		TimerListener listener = new TimerListener(_panel, this, _timer, _mainPanel);
		_timer.addActionListener(listener);
		 
		
		//add labels and buttons to RadioButtonsPanel
		
		//this.add(buttonForEasy);
		//this.add(buttonForMedium);
		//this.add(buttonForHard);
		//this.add(buttonFor2rows);
		//this.add(buttonFor3rows);
		//this.add(buttonFor5rows);
		this.add(_startStop);
		this.add(_quit);
		this.add(_mainMenu);
		this.add(_scorelabel );
		this.add(_resetGame );
		
		
	}
	//updates score label with every hit of a Brick
	public void updateScore() {
		_scorelabel.setText("Score: " + _panel.getScore());
	}
	//resets the game back to the original state
	public void resetGame() {
		_timer.stop();
		_holder.resetBrickCount();
	}
	//Sets the Buttons to the gameOver Text
	public void gameOverText() {
		_startStop.setText("GAME OVER");
		
		_resetGame.setVisible(true);
	}
	//Sets the Buttons to the gameWon Text
	public void gameWonText() {
		_startStop.setText("GAME WON");
		
		_resetGame.setVisible(true);
	}
	public void setinvis(boolean f) {
		this.setVisible(f);
	}
	
	
	public class ButtonListener implements ActionListener, KeyListener {
    	
    	private int _state;
    	private ControlPanel _cp;
    	private MainPanel _mp;
    	private BrickPanel _bp;
    	private MainMenu _mm;
    	
    	public ButtonListener(int state, ControlPanel cp, MainPanel mp, BrickPanel bp, MainMenu mm) {
    		_state = state;
    		_cp = cp;
    		_mp = mp;
    		_bp = bp;
    		_mm = mm;
    	}
    	
    	@Override
    	public void actionPerformed(ActionEvent e){
    		//When the button is clicked it switches the textlabel from start to stop
    		if (_holder.getBallSpeed() != 0) {
    		if(_startStop.getText() == "Start" || _startStop.getText() == "Stop") {
    		if (_state == 0) {
    		if (i%2 == 0) {
    			_startStop.setText("Stop");
    			_timer.start();
    			_panel.requestFocusInWindow();
    			
    		}
    		//When the button is clicked again it switches the text to start
    		else{
    			_startStop.setText("Start");
    		_timer.stop();
    		_panel.requestFocusInWindow();
    		}
    		}
    		i++;
    		}
    		}
    		
    		//if the reset button is clicked the game will call the reset methods 
    		//and switch the texts.
    		if (_state == 2) {
    			_mainPanel.resetGame();
    			_resetGame.setVisible(false);
    			_startStop.setText("Start");
    			_panel.resetScore();
    			i++;
    			
    		}
    		if (_state == 1) {
    			_cp.setVisible(false);
    			_bp.setVisible(false);
    			_mm.setVisible(true);
    			_mp._gameState = ("MainMenu");
    			_mp.repaint();
    			_mainPanel.resetGame();
    			_resetGame.setVisible(false);
    			_startStop.setText("Start");
    			_panel.resetScore();
    			i++;
    			_timer.stop();
    		}
    		
    	}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
			
			
			 
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
			
		}

		
    }

