import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class BallShape {
	//Instance Variables
	private Ellipse2D.Double _ball;
	//Constructor
	public BallShape() {
		_ball = new Ellipse2D.Double();
		setSize(15, 15);
	}
	//Sets the location of the ball
	public void setLocation(double x, double y) {

		_ball.setFrame(x, y, _ball.getWidth(), _ball.getHeight());

	}
	//Sets the size of the ball
	public void setSize(double w, double h) {
		_ball.setFrame(_ball.getX(), _ball.getY(), w, h);
	}
	//Returns the shape of the ball Ellipse2D.Double
	public Ellipse2D.Double getMyShape() {
		return _ball;
	}
	//Returns the ball's X location
	public double getX() {
		return _ball.getX();
	}
	//Returns the ball's X location
	public double getY() {
		return _ball.getY();
	}

	public void paint(Graphics2D brush) {
		
		brush.draw(_ball);
		brush.fill(_ball);
	}
}

