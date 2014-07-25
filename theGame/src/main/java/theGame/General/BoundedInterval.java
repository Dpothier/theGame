package theGame.General;


public class BoundedInterval extends Interval {

	private Interval container;

	public BoundedInterval(Interval container, int startPoint, int endPoint) {
		super(startPoint, endPoint);
		this.container = container;
		if(startPoint < container.getStartPoint() || endPoint > container.getEndPoint()){
			throw new RuntimeException("The start point or end point are out of bounds");
		}
	}
	
	public Interval move(int x){
		Interval toReturn;
		try{
			toReturn = new BoundedInterval(container, startPoint + x, endPoint + x);
		} catch(Exception e){
			return this;
		}
		return toReturn;
		
	}

}
