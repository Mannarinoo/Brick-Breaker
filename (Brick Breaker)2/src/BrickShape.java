
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;


import javax.swing.ImageIcon;

public class BrickShape {
	//Instance Variables
	private Image _brick;
	private int x;
	private int y;
	//Constructor- creates new brick image with specified location
	public BrickShape( int xloc, int yloc){
		_brick = new ImageIcon("Brick.jpg").getImage();
		x = xloc;
		y = yloc;
	}
	//sets the location of the Brick
	public void setLocation(int xloc, int yloc) {
		x = xloc;
		y = yloc;
	}
	//gets the X location of the Brick
	public int getX() {
		return x;
	}
	//gets the Y location of the Brick
	public int getY() {
		return y;
	
	}
	//Gets the image of the Brick
	public Image getImage() {
		return _brick;
	}
	public void changebrickColor() {
		_brick = new ImageIcon("Brick2.jpg").getImage();
	}
	
}
