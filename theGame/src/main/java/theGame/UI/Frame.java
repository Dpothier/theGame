package theGame.UI;

import theGame.General.Interval;

public class Frame {
	
	private Interval width;
	private Interval heigth;
	private Interval boundsInX;
	private Interval boundsInY;
	
	public Frame(Interval width, Interval heigth, Interval boundsInX, Interval boundsInY) {
		this.width = width;
		this.heigth = heigth;
		this.boundsInX = boundsInX;
		this.boundsInY = boundsInY;
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
		if(canMove(x, y))
		{
			width = width.move(x);
			heigth = heigth.move(y);
		}
	}

	private boolean canMove(int x, int y) {
		if(!(boundsInX.contains(width.move(x)) && boundsInY.contains(heigth.move(y)))){
			return false;
		}
		return true;
	}

}
