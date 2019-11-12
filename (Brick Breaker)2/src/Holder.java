
public class Holder {
	private int _brickCount;
	private int _brickAmount;
	private int _ballSpeed;
	private int _rows;
	private BrickPanel _bPanel;
public Holder(BrickPanel bp) {
	_bPanel = bp;
}
public void setBrickCount(int x) {
	 _rows = x;
	if(_rows == 2) {
		_brickCount = 13;
		_brickAmount = 13;
	}
	if(_rows == 3) {
		_brickCount = 20;
		_brickAmount = 20;
	}
	if(_rows == 5) {
		_brickCount = 34;
		_brickAmount = 34;
	}
	
	

}
public void resetBrickCount() {
	
	if(_rows == 2) {
		_brickCount = 13;
		_brickAmount = 13;
	}
	if(_rows == 3) {
		_brickCount = 20;
		_brickAmount = 20;
	}
	if(_rows == 5) {
		_brickCount = 34;
		_brickAmount = 34;
	}
}
public int getBrickCount() {
	return _brickCount;
}
public int getBrickAmount() {
	return _brickAmount;
}
public void decreaseBrickCount() {
	_brickCount--;
}
public void setBallSpeed(int dx) {
	_ballSpeed = dx;
}
public int getBallSpeed() {
	return _ballSpeed;
}

}
