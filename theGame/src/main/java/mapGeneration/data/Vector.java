package mapGeneration.data;

public class Vector {
	public double x;
	public double y;
	
	public Vector(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double dotProduce(Vector otherVector){
		return this.x*otherVector.x + this.y*otherVector.y;
	}
}
