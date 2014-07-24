package mapGeneration;

import theGame.UI.Tile;
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
	
	public Tile[][] generateHeigthMap(){
		Tile[][] heigthMap = new Tile[width][heigth];
		for(int i = 0; i < width; i++){
			for(int j = 0; j < heigth; j++){
				heigthMap[i][j] = new Tile(noise.generatePixel(i, j));
			}
		}
		return heigthMap;
	}

}
