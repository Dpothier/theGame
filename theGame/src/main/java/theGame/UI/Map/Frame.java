package theGame.UI.Map;

import mapGeneration.display.TileDrawer;

import org.junit.Assert;

import theGame.General.BoundedInterval;
import theGame.General.Interval;
import theGame.General.Point;
import theGame.General.Rectangle;

public class Frame {
	
	private Point anchor;
	private int xSize;
	private int ySize;
	private Rectangle position;
	private Zoom zoom;
	private int numberOfXTiles;
	private int numberOfYTiles;
	
	public Frame(Rectangle position, Zoom zoom, int numberOfXTiles, int numberOfYTiles) {
		this.position = position;
		this.zoom = zoom;
		this.numberOfXTiles = numberOfXTiles;
		this.numberOfYTiles = numberOfYTiles;
	}
	
	public Frame(Point anchor, int xSize, int ySize){
		this.anchor = anchor;
		this.xSize = xSize;
		this.ySize = ySize;
	}
	
	public Tile[][] tilesInFrame2(Tile[][] tiles){
		Tile[][] submapTiles = new Tile[][];
		return tiles;
		
	}
	
	public Tile[][] tilesInFrame(Tile[][] tiles){
		int numberOfXTiles = tilesInPixels(position.width(), zoom.getSize());
		int numberOfYTiles = tilesInPixels(position.heigth(), zoom.getSize());
		Tile[][] submapTiles = new Tile[numberOfXTiles][numberOfYTiles];
		for(int i = 0; i < submapTiles.length; i++){
			for(int j = 0; j < submapTiles[i].length; j++){
				submapTiles[i][j] = tiles[i + position.lowerLeftCorner().x][j + position.lowerLeftCorner().y];
			}
		}
		return submapTiles;
		
	}
	
	private int tilesInPixels(int numberOfPixels, int sizeOfTileInPixels) {
		return (int)Math.ceil((float)numberOfPixels/(float)sizeOfTileInPixels);
	}

	public Frame move(int x, int y){
			position = position.move(x, y);
			return new Frame(position.move(x, y),zoom, numberOfXTiles, numberOfYTiles);
	}
	
	public Frame zoom(){
		zoom.zoom();
		return new Frame(position)
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
