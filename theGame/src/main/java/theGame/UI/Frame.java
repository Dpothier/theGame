package theGame.UI;

import mapGeneration.display.TileDrawer;

import org.junit.Assert;

import theGame.General.BoundedInterval;
import theGame.General.Interval;

public class Frame {
	
	private Interval width;
	private Interval heigth;
	private Zoom zoom;
	
	public Frame(Interval width, Interval heigth, Zoom zoom) {
		this.width = width;
		this.heigth = heigth;
		this.zoom = zoom;
	}
	
	public Interval getWidth(){
		return width;
	}
	
	public Interval getHeigth(){
		return heigth;
	}
	
	public Tile[][] tilesInFrame(Tile[][] tiles){
		Tile[][] submapTiles = new Tile[width.distance() + 1][heigth.distance() + 1];
		for(int i = 0; i < width.distance() + 1; i++){
			for(int j = 0; j < heigth.distance()+1; j++){
				submapTiles[i][j] = tiles[i + width.getStartPoint()][j + heigth.getStartPoint()];
			}
		}
		return submapTiles;
		
	}
	
	public void move(int x, int y){
			width = width.move(x);
			heigth = heigth.move(y);
	}

	public void draw(Tile[][] tiles, TileDrawer drawer, int tileSize) {
		Tile[][] framedTiles = tilesInFrame(tiles);
		
		for(int i = 0; i < framedTiles.length; i++){
			for(int j = 0; j < framedTiles[i].length; j++){
				drawer.drawTile(i*zoom.getSize(), j*zoom.getSize(),zoom.getSize(), framedTiles[i][j]);
			}
		}
		
	}

}
