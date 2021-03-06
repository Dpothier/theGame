package engine.display;

public class Point {
	public int x;
	public int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	public Point add(Point otherPoint) {
		return new Point(x + otherPoint.x, y + otherPoint.y);
	}
	
}
