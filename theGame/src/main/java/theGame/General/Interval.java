package theGame.General;

public class Interval {

	private int startPoint;
	private int endPoint;
	
	public Interval(int startPoint,int endPoint){
		if(startPoint > endPoint){
			throw new RuntimeException("Distance: start point greater than endPoint");
		}
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public int getStartPoint(){
		return startPoint;
	}
	
	public int getEndPoint(){
		return endPoint;
	}

	public int distance() {
		return endPoint - startPoint;
	}
	
	public Interval move(int distance){
		return new Interval(startPoint + distance, endPoint + distance);
	}
	
	public boolean contains(Interval other){
		return (other.startPoint >= startPoint && other.endPoint <= endPoint);
	}
}
