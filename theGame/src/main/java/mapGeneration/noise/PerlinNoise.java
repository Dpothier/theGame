package mapGeneration.noise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import mapGeneration.data.Vector;
import mapGeneration.data.Gradients;

public class PerlinNoise implements Noise{
	
	private Vector[][] gradiantTable = new Vector[8][8];
	private int res;
	
	public PerlinNoise(int res){
		this.res = res;
		generateGradiantTable();
	}
	
	private void generateGradiantTable() {
		Random random = new Random();
		for(int i = 0; i < 8; i ++){
			for(int j = 0; j < 8; j++){
				int angle = random.nextInt(360);
				gradiantTable[i][j] = new Vector(Math.cos(angle), Math.sin(angle));
			}
		}
		
	}



	public double[][] generateHeigthMap(int heigth, int width){
		double[][] heigthMap = new double[heigth][width];
		for(int i = 0; i < heigth; i++){
			for(int j = 0; j < width; j++){
				heigthMap[i][j] = (generatePixel(i, j)+1)/2;
			}
		}
		return heigthMap;
		
	}

	public double generatePixel(double i, double j) {
		double x = ((double)i) /res;
		double y = ((double)j) /res;
		
		double fractionnalX = x - (int)x;
		double fractionnalY = y - (int)y;
		
		Vector upperLeftGridPoint = gradiantTable[(int) Math.floor(x)%8][(int) Math.floor(y)%8];
		Vector upperRigthGridPoint = gradiantTable[(int)Math.ceil(x)%8][(int)Math.floor(y)%8];
		Vector lowerLeftGridPoint = gradiantTable[(int)Math.floor(x)%8][(int) Math.ceil(y)%8];
		Vector lowerRigthGridPoint = gradiantTable[(int)Math.ceil(x)%8][(int)Math.ceil(y)%8];
		
		Vector distanceToUpperLeft = new Vector(fractionnalX, fractionnalY);
		Vector distanceToUpperRigth= new Vector(fractionnalX - 1, fractionnalY);
		Vector distanceToLowerLeft = new Vector(fractionnalX, fractionnalY - 1);
		Vector distanceToLowerRigth = new Vector(fractionnalX - 1, fractionnalY - 1);
		
		double s = upperLeftGridPoint.dotProduce(distanceToUpperLeft);
		double t = upperRigthGridPoint.dotProduce(distanceToUpperRigth);
		double u = lowerLeftGridPoint.dotProduce(distanceToLowerLeft);
		double v = lowerRigthGridPoint.dotProduce(distanceToLowerRigth);
		
		double fadedX = fade(fractionnalX);
		double fadedY = fade(fractionnalY);
		
		double interpolatedX1 = lerp(s,t,fadedX);
		double interpolatedX2 = lerp(u,v,fadedX);
		return (lerp(interpolatedX1, interpolatedX2, fadedY)+1)/2;

	}

	private double fade(double x) {
		return 6 * x * x * x * x * x -
			  15 * x * x * x * x +
			  10 * x * x * x;
	}
	
	private double lerp(double a, double b, double f) 
	{
	    return (a * (1.0f - f)) + (b * f);
	}

	

}
