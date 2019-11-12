import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;





/**
 * Joey Mannarino
 * 4/21/2018
 * Lab 12
 * 
 * Chapter 7: BrickPanel.java Creates the panel to be placed inside the BallApp
 * window.
 */
public class BrickPanel extends javax.swing.JPanel
{
	//Instance Variables

    private int INIT_X = 200;
    private final int INIT_Y = 275;
    private PaddleShape _paddle1;
    private PaddleShape _paddle2;
    private int _paddlestate = 1;
    private BallShape _ball;
    private double xloc = -2;
	private double yloc = -6;
	private PaddleShape _paddleLine;
	private java.awt.Graphics2D betterBrush;
	private int _score = 0;
	private ArrayList<BrickShape> BrickArray;
	private Holder _holder;
	private ControlPanel _cp;
	private MainPanel _mp;
	private int _ballSpeed;
	int timer = 0;
	int temp = 34;
	Random rand = new Random();
	int extendPaddle = rand.nextInt(temp);
    int speedUp = rand.nextInt(temp);
	//Constructor- Creates and adds Paddles, Bricks, and Ball to panel
    public BrickPanel(Holder holder, PaddleShape paddle1, PaddleShape paddle2, ControlPanel cp, MainPanel mp)
    {
        super();
       _holder = holder;
       _cp = cp;
       _mp = mp;
       
       
       
        this.setSize(450, 200);
       
        this.setBackground(java.awt.Color.white);
        
		this.setLayout(new GridLayout(4,4));
		
		
				
        _paddle1 = new PaddleShape();
		
        _paddle1.setLocation(INIT_X, INIT_Y);
        _paddle2 = new PaddleShape();
        _paddle2.setLocation(300, INIT_Y);
        _paddleLine = new PaddleShape(800, 5);
        _paddleLine.setLocation(0, 240);
        
       
        
        BrickArray = new ArrayList<BrickShape>();
        BrickArray.add(new BrickShape(0, 0));
        BrickArray.add(new BrickShape(114, 0));
        BrickArray.add(new BrickShape(228, 0));
        BrickArray.add(new BrickShape(342, 0));
        BrickArray.add(new BrickShape(456, 0));
        BrickArray.add(new BrickShape(570, 0));
        BrickArray.add(new BrickShape(684, 0));
        BrickArray.add(new BrickShape(0, 26));
        BrickArray.add(new BrickShape(114, 26));
        BrickArray.add(new BrickShape(228, 26));
        BrickArray.add(new BrickShape(342, 26));
        BrickArray.add(new BrickShape(456, 26));
        BrickArray.add(new BrickShape(570, 26));
        BrickArray.add(new BrickShape(684, 26));
        BrickArray.add(new BrickShape(0, 52));
        BrickArray.add(new BrickShape(114, 52));
        BrickArray.add(new BrickShape(228, 52));
        BrickArray.add(new BrickShape(342, 52));
        BrickArray.add(new BrickShape(456, 52));
        BrickArray.add(new BrickShape(570, 52));
        BrickArray.add(new BrickShape(684, 52));
        BrickArray.add(new BrickShape(0, 78));
        BrickArray.add(new BrickShape(114, 78));
        BrickArray.add(new BrickShape(228, 78));
        BrickArray.add(new BrickShape(342, 78));
        BrickArray.add(new BrickShape(456, 78));
        BrickArray.add(new BrickShape(570, 78));
        BrickArray.add(new BrickShape(684, 78));
        BrickArray.add(new BrickShape(0, 104));
        BrickArray.add(new BrickShape(114, 104));
        BrickArray.add(new BrickShape(228, 104));
        BrickArray.add(new BrickShape(342, 104));
        BrickArray.add(new BrickShape(456, 104));
        BrickArray.add(new BrickShape(570, 104));
        BrickArray.add(new BrickShape(684, 104));
    
        
        _ball = new BallShape();
        _ball.setLocation(250, 200);
        this.setFocusable(true);
        MyClickListener listener = new MyClickListener(this, _cp, _mp);
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
        this.addKeyListener(listener);
       
       
        // The ball panel needs to add a new MouseListener, KeyListener, and
        // MouseMotionListener in its constructor. To receive key events, it must also
        // be focusable.
       
    }
    //Sets the Rows of Bricks on the panel
    public void updateBrickCount() {
    	//_brickCount = _holder.getBrickCount();
    	//_brickAmount = _holder.getBrickCount();
    	repaint();
    }
  
    //Returns the Score of the game
    public int getScore() {
    	return _score;
    }
    //Returns the amount of bricks left on the panel
    public int getBrickCount() {
    	return _holder.getBrickCount();
    }
    //Returns the shape of the ball - BallShape
    public BallShape getBallShape() {
    	return _ball;
    }
    //Resets the score of the game
    public void resetScore() {
    	_score = 0;
    }
    //Resets the location of the Bricks 
    public void resetBrickLocation() {
    	
    	BrickArray.get(0).setLocation(0, 0);
    	BrickArray.get(1).setLocation(114, 0);
    	BrickArray.get(2).setLocation(228, 0);
    	BrickArray.get(3).setLocation(342, 0);
    	BrickArray.get(4).setLocation(456, 0);
    	BrickArray.get(5).setLocation(570, 0);
    	BrickArray.get(6).setLocation(684, 0);
    	BrickArray.get(7).setLocation(0, 26);
    	BrickArray.get(8).setLocation(114, 26);
    	BrickArray.get(9).setLocation(228, 26);
    	BrickArray.get(10).setLocation(342, 26);
    	BrickArray.get(11).setLocation(456, 26);
    	BrickArray.get(12).setLocation(570, 26);
    	BrickArray.get(13).setLocation(684, 26);
    	BrickArray.get(14).setLocation(0, 52);
    	BrickArray.get(15).setLocation(114, 52);
    	BrickArray.get(16).setLocation(228, 52);
    	BrickArray.get(17).setLocation(342, 52);
    	BrickArray.get(18).setLocation(456, 52);
    	BrickArray.get(19).setLocation(570, 52);
    	BrickArray.get(20).setLocation(684, 52);
    	BrickArray.get(21).setLocation(0, 78);
    	BrickArray.get(22).setLocation(114, 78);
    	BrickArray.get(23).setLocation(228, 78);
    	BrickArray.get(24).setLocation(342, 78);
    	BrickArray.get(25).setLocation(456, 78);
    	BrickArray.get(26).setLocation(570, 78);
    	BrickArray.get(27).setLocation(684, 78);
    	BrickArray.get(28).setLocation(0, 104);
    	BrickArray.get(29).setLocation(114, 104);
    	BrickArray.get(30).setLocation(228, 104);
    	BrickArray.get(31).setLocation(342, 104);
    	BrickArray.get(32).setLocation(456, 104);
    	BrickArray.get(33).setLocation(570, 104);
    	BrickArray.get(34).setLocation(684, 104);
    }
    //Resets the location of the ball to its original position
    public void resetBallLocation() {
    	_ball.setLocation(250, 200);
    	yloc = -yloc;
    	this.resetBrickLocation();
    	repaint();
    }
    

    public void paintComponent(java.awt.Graphics aBrush)
    {
        super.paintComponent(aBrush);
        betterBrush = (java.awt.Graphics2D) aBrush;
        _paddle1.paint(betterBrush);
        _paddle2.paint(betterBrush);
        _ball.paint(betterBrush);
        _paddleLine.paint(betterBrush);
        if (_holder.getBrickAmount() == 13 || _holder.getBrickAmount() == 20 || _holder.getBrickAmount() == 34)
        for (int i = 0; i <= _holder.getBrickAmount() ; i++ ) {
        	aBrush.drawImage(BrickArray.get(i).getImage(), BrickArray.get(i).getX(), BrickArray.get(i).getY(), 114, 25, null);
        
        }
        //Change the color of the brick that has the power up within it.
        
        BrickArray.get(extendPaddle).changebrickColor();
        BrickArray.get(speedUp).changebrickColor();
        
    }
    //Moves the paddle across the panel
    public void movePaddles(double x, double y) {
    	if (_paddlestate == 1) {
    	_paddle1.setLocation(_paddle1.getX() + x, _paddle1.getY() + y);
    	}
    	if (_paddlestate == 2) {
    	_paddle2.setLocation(_paddle2.getX() + x, _paddle2.getY() + y);
    	}
    	
    	repaint();
    }
    
    /*
     * Moves the ball across the screen and bounces it off the paddles, 
     * Bricks and sides of the Frame
     */
    public void moveBall() {
    	
    	
    	if (yloc < 0) {
    	yloc = -_holder.getBallSpeed();
    	}
    	if (yloc > 0) {
        	yloc = _holder.getBallSpeed();
        	}
    	if(_ball.getX() <= 0 || _ball.getX() >= 750)
		{
    		
    		xloc = -xloc;
    		
		}

		if (_ball.getY() <= 0 )  
		{
			
			yloc = -yloc;
		}
		
		
		
		
		if (_ball.getMyShape().intersects(_paddle1.getX(), _paddle1.getY(), _paddle1.getWidth(), _paddle1.getHeight()) || _ball.getMyShape().intersects(_paddle2.getX(), _paddle2.getY(), _paddle2.getWidth(), _paddle2.getHeight())) {
			yloc = -yloc;
			
		}
		
		if (_holder.getBrickAmount() == 13 || _holder.getBrickAmount() == 20 || _holder.getBrickAmount() == 34) {
		if (_ball.getMyShape().intersects(BrickArray.get(0).getX(), BrickArray.get(0).getY(), 114, 25)) {
				BrickArray.get(0).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
			}
		else if (_ball.getMyShape().intersects(BrickArray.get(1).getX(), BrickArray.get(1).getY(), 114, 25)) {
			BrickArray.get(1).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(2).getX(), BrickArray.get(2).getY(), 114, 25)) {
			BrickArray.get(2).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(3).getX(), BrickArray.get(3).getY(), 114, 25)) {
			BrickArray.get(3).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(4).getX(), BrickArray.get(4).getY(), 114, 25)) {
			BrickArray.get(4).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(5).getX(), BrickArray.get(5).getY(), 114, 25)) {
			BrickArray.get(5).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(6).getX(), BrickArray.get(6).getY(), 114, 25)) {
			BrickArray.get(6).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(7).getX(), BrickArray.get(7).getY(), 114, 25)) {
			BrickArray.get(7).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(8).getX(), BrickArray.get(8).getY(), 114, 25)) {
			BrickArray.get(8).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(9).getX(), BrickArray.get(9).getY(), 114, 25)) {
			BrickArray.get(9).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(10).getX(), BrickArray.get(10).getY(), 114, 25)) {
			BrickArray.get(10).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(11).getX(), BrickArray.get(11).getY(), 114, 25)) {
			BrickArray.get(11).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(12).getX(), BrickArray.get(12).getY(), 114, 25)) {
			BrickArray.get(12).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(13).getX(), BrickArray.get(13).getY(), 114, 25)) {
			BrickArray.get(13).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		
		
		
		}
		if( _holder.getBrickAmount() == 20 || _holder.getBrickAmount() == 34) {
			if (_ball.getMyShape().intersects(BrickArray.get(14).getX(), BrickArray.get(14).getY(), 114, 25)) {
				BrickArray.get(14).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
			}
			else if (_ball.getMyShape().intersects(BrickArray.get(15).getX(), BrickArray.get(15).getY(), 114, 25)) {
				BrickArray.get(15).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
		}
			else if (_ball.getMyShape().intersects(BrickArray.get(16).getX(), BrickArray.get(16).getY(), 114, 25)) {
			BrickArray.get(16).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(17).getX(), BrickArray.get(17).getY(), 114, 25)) {
			BrickArray.get(17).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(18).getX(), BrickArray.get(18).getY(), 114, 25)) {
			BrickArray.get(18).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(19).getX(), BrickArray.get(19).getY(), 114, 25)) {
			BrickArray.get(19).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
		}
		else if (_ball.getMyShape().intersects(BrickArray.get(20).getX(), BrickArray.get(20).getY(), 114, 25)) {
			BrickArray.get(20).setLocation(0, 600);
			yloc = -yloc;
			_score = _score + 10;
			_holder.decreaseBrickCount();
			
		}
		
		
		
		}
    
		if ( _holder.getBrickAmount() == 34) {
			if (_ball.getMyShape().intersects(BrickArray.get(21).getX(), BrickArray.get(21).getY(), 114, 25)) {
				BrickArray.get(21).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
		}
		
			else if (_ball.getMyShape().intersects(BrickArray.get(22).getX(), BrickArray.get(22).getY(), 114, 25)) {
				BrickArray.get(22).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
			}
			else if (_ball.getMyShape().intersects(BrickArray.get(23).getX(), BrickArray.get(23).getY(), 114, 25)) {
				BrickArray.get(23).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
		}
			else if (_ball.getMyShape().intersects(BrickArray.get(24).getX(), BrickArray.get(24).getY(), 114, 25)) {
				BrickArray.get(24).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
		}
			else if (_ball.getMyShape().intersects(BrickArray.get(25).getX(), BrickArray.get(25).getY(), 114, 25)) {
				BrickArray.get(25).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
		}
			else if (_ball.getMyShape().intersects(BrickArray.get(26).getX(), BrickArray.get(26).getY(), 114, 25)) {
				BrickArray.get(26).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
		}
			else if (_ball.getMyShape().intersects(BrickArray.get(27).getX(), BrickArray.get(27).getY(), 114, 25)) {
				BrickArray.get(27).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
		}
			else if (_ball.getMyShape().intersects(BrickArray.get(28).getX(), BrickArray.get(28).getY(), 114, 25)) {
				BrickArray.get(28).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
			
		}
			else if (_ball.getMyShape().intersects(BrickArray.get(29).getX(), BrickArray.get(29).getY(), 114, 25)) {
				BrickArray.get(29).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
		}
			else if (_ball.getMyShape().intersects(BrickArray.get(30).getX(), BrickArray.get(30).getY(), 114, 25)) {
				BrickArray.get(30).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
		}
			else if (_ball.getMyShape().intersects(BrickArray.get(31).getX(), BrickArray.get(31).getY(), 114, 25)) {
				BrickArray.get(31).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
		
	}
			else if (_ball.getMyShape().intersects(BrickArray.get(32).getX(), BrickArray.get(32).getY(), 114, 25)) {
				BrickArray.get(32).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
	}
			else if (_ball.getMyShape().intersects(BrickArray.get(33).getX(), BrickArray.get(33).getY(), 114, 25)) {
				BrickArray.get(33).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
	}
			else if (_ball.getMyShape().intersects(BrickArray.get(34).getX(), BrickArray.get(34).getY(), 114, 25)) {
				BrickArray.get(34).setLocation(0, 600);
				yloc = -yloc;
				_score = _score + 10;
				_holder.decreaseBrickCount();
	}
	}
		  
    	_ball.setLocation(_ball.getX() + xloc , _ball.getY() + yloc);
	//create a random number in order to produce power ups within the bricks
    	 
    if (_ball.getMyShape().intersects(BrickArray.get(extendPaddle).getX(), BrickArray.get(extendPaddle).getY(), 114, 25) && extendPaddle <= _holder.getBrickAmount()) {
    	_paddle1.setSize(100, 10);
    	_paddle2.setSize(100, 10);
    	
    }
    if (_ball.getMyShape().intersects(BrickArray.get(speedUp).getX(), BrickArray.get(speedUp).getY(), 114, 25)&& speedUp <= _holder.getBrickAmount()) {
    	_ballSpeed = _holder.getBallSpeed();
    	_holder.setBallSpeed(15);
    	
    }
    
	timer++;
	if (_holder.getBallSpeed() == 6) {
    if (timer % 200 == 0) {
		_paddle1.setSize(75, 8);
		_paddle2.setSize(75, 8);
		_holder.setBallSpeed(_ballSpeed);
	}
	}
	if (_holder.getBallSpeed() == 9) {
	    if (timer % 300 == 0) {
			_paddle1.setSize(75, 8);
			_paddle2.setSize(75, 8);
			_holder.setBallSpeed(_ballSpeed);
		}
		}
	if (_holder.getBallSpeed() == 12) {
	    if (timer % 300 == 0) {
			_paddle1.setSize(75, 8);
			_paddle2.setSize(75, 8);
			_holder.setBallSpeed(_ballSpeed);
		}
		}
    	
    	repaint();
    }
    
	private class MyClickListener implements MouseListener, MouseMotionListener, KeyListener
{
	
	
	private BrickPanel _ballPanel;
	private ControlPanel _cp;
	private MainPanel _mp;
	java.awt.Point lastMousePosition;
	
	public MyClickListener(BrickPanel ballpanel, ControlPanel cp, MainPanel mp)
	{
		_ballPanel = ballpanel;
		_mp = mp;
		_cp = cp;
}

	public void mouseClicked (java.awt.event.MouseEvent e){}
	//When the paddle is pressed the mouse location is saved and the 
	//state is set.
	public void mousePressed(MouseEvent e) {
		if (_paddle1.getMyShape().contains(e.getPoint())){
			lastMousePosition = e.getPoint();
			_paddlestate = 1;
		}
		if (_paddle2.getMyShape().contains(e.getPoint())){
			lastMousePosition = e.getPoint();
			_paddlestate = 2;
		}
	
		
	}
	
	public void keyPressed(KeyEvent e) {
		//When the left keypad is pressed the paddles moves left
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			if (_paddle1.getX() > 0 &&  _paddle2.getX() > 0) {
			_ballPanel.movePaddles(-10, 0);
			
			}
			else {
				if (_paddle1.getX() > 710) {
					_ballPanel.movePaddles(10, 0);
				}
			}
		}
		//When the right keypad is pressed the paddles moves right
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if (_paddle1.getX() < 710 &&  _paddle2.getX() < 710) {
			_ballPanel.movePaddles(10, 0);
			
			}
			else {
				if (_paddle1.getX() < 0) {
					_ballPanel.movePaddles(-10, 0);
				}
			}
		}
		if (e.getKeyCode()== 83) {
			_mp.setControlsinvis(false);
			_ballPanel.setVisible(false);
			_mp.setGameState("Shop");
			_mp.repaint();
			
		}
		 
	}
	public void mouseDragged(MouseEvent e) {
		//If the mouse presses the paddles the paddle will move with the mouse
		if (_paddle1.getMyShape().contains(e.getPoint())) {
		int diffX = e.getX() - lastMousePosition.x;
		int diffY = e.getY() - lastMousePosition.y;
		_paddlestate = 1;
		if (e.getY() > 250 && e.getY() < 340) {
			_ballPanel.movePaddles(diffX, diffY);
			lastMousePosition = e.getPoint();
		}
		}
		if (_paddle2.getMyShape().contains(e.getPoint())) {
			int diffX = e.getX() - lastMousePosition.x;
			int diffY = e.getY() - lastMousePosition.y;
			_paddlestate = 2;
			if (e.getY() > 250 && e.getY() < 340) {
				_ballPanel.movePaddles(diffX, diffY);
				lastMousePosition = e.getPoint();
			}
			
			}
	}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

	public void mouseMoved(MouseEvent arg0) {}
	}
}
