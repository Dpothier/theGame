package mapGeneration.data;

public class Gradients {
	
	private Vector[]  gradientList = new Vector[8];
	
	public Gradients(){
		double unit = 1/Math.sqrt(2);
		gradientList[0] = new Vector(unit, unit);
		gradientList[1] = new Vector(unit, -unit);
		gradientList[2] = new Vector(-unit, unit);
		gradientList[3] = new Vector(-unit, -unit);
		gradientList[4] = new Vector(1,0);
		gradientList[5] = new Vector(0,1);
		gradientList[6] = new Vector(-1,0);
		gradientList[7] = new Vector(0,-1);
	}
	
	public Vector getGradient(int index){
		
		return gradientList[index % gradientList.length];
		
	}
	

}
