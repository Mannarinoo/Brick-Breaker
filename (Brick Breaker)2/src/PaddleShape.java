import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class PaddleShape {

	//Instance Variables
	private Rectangle2D.Double _paddle;
	private double _width;
	private double _height;
	//Constructor- Creates a new paddle of Rectangle.Double and sets its size/color
	public PaddleShape(){
		_paddle = new Rectangle.Double();
		
		setSize(75,8);
	}
	//Constructor that takes ints for the size of the paddle.
	public PaddleShape(int sizex, int sizey) {
		_paddle = new Rectangle.Double();
		
		setSize(sizex, sizey);
	}
	//Sets the location of the paddle
	public void setLocation(double x, double y){
		_paddle.setFrame(x, y, _paddle.getWidth(), _paddle.getHeight());
		
	}
	//Sets the size of the paddle 
	public void setSize(double w,double h){
		_paddle.setFrame(_paddle.getX(), _paddle.getY(), w, h);
		_width = w;
		_height = h;
	}
	//Returns the Shape of the paddle RectangularShape
	public RectangularShape getMyShape() {
		return _paddle;
	}
	//Returns the X location of the paddle
	public double getX() {
		return _paddle.getX();
	}
	//Returns the Y location of the paddle
	public double getY() {
		return _paddle.getY();
	}	
	public double getWidth() {
		return _width;
	}
	public double getHeight() {
		return _height;
	}
	public void paint(Graphics2D brush){
		brush.setColor(java.awt.Color.BLACK);
	    brush.draw(_paddle);		
		brush.setColor(java.awt.Color.BLACK);
		brush.fill(_paddle);
		
	}
}
