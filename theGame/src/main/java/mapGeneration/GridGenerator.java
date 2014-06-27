package mapGeneration;

import mapGeneration.noise.Noise;

public class GridGenerator {
	
	private int width;
	private int heigth;
	private Noise noise;

	public GridGenerator(int width, int heigth, Noise noise){
		this.width = width;
		this.heigth = heigth;
		this.noise = noise;
	}
	
	public double[][] generateHeigthMap(){
		double[][] heigthMap = new double[width][heigth];
		for(int i = 0; i < width; i++){
			for(int j = 0; j < heigth; j++){
				heigthMap[i][j] = noise.generatePixel(i, j);
			}
		}
		return heigthMap;
	}

}
