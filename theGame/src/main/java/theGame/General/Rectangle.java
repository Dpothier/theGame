package theGame.General;

public class Rectangle {
	
	private BoundedInterval x;
	private BoundedInterval y;

	public Rectangle(BoundedInterval x, BoundedInterval y){
		this.x = x;
		this.y = y;
	}
	
	public Rectangle move(int deltaX, int deltaY){
		return new Rectangle(x.move(deltaX), y.move(deltaY));
	}
	
	
	public int width(){
		return x.length();
	}

	public int heigth() {
		return y.length();
	}
	
	public Point lowerLeftCorner(){
		return new Point(x.startPoint, y.startPoint);
		
	}

}
