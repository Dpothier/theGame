package mapGeneration.data;

public class Gradients {
	
	private Gradient[]  gradientList = new Gradient[8];
	
	public Gradients(){
		double unit = 1/Math.sqrt(2);
		gradientList[0] = new Gradient(unit, unit);
		gradientList[1] = new Gradient(unit, -unit);
		gradientList[2] = new Gradient(-unit, unit);
		gradientList[3] = new Gradient(-unit, -unit);
		gradientList[4] = new Gradient(1,0);
		gradientList[5] = new Gradient(0,1);
		gradientList[6] = new Gradient(-1,0);
		gradientList[7] = new Gradient(0,-1);
	}
	
	public Gradient getGradient(int index){
		
		return gradientList[index % gradientList.length];
		
	}
	

}
