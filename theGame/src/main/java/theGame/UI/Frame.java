package theGame.UI;

import org.junit.Assert;

import theGame.General.BoundedInterval;
import theGame.General.Interval;

public class Frame {
	
	private Interval width;
	private Interval heigth;
	
	public Frame(Interval width, Interval heigth) {
		this.width = width;
		this.heigth = heigth;
	}
	
	public Tile[][] tilesInFrame(Tile[][] tiles){
		Tile[][] submapTiles = new Tile[width.distance() + 1][heigth.distance() + 1];
		for(int i = 0; i < width.distance() + 1; i++){
			for(int j = 0; j < heigth.distance() + 1; j++){
				submapTiles[i][j] = tiles[i + width.getStartPoint()][j + heigth.getStartPoint()];
			}
		}
		return submapTiles;
		
	}
	
	public void move(int x, int y){
			width = width.move(x);
			heigth = heigth.move(y);
	}

}
