package theGame.UI;

import theGame.General.Interval;
import mapGeneration.display.TileDrawer;

public class Map implements Widget{
	
	private Tile[][] tiles;
	private TileDrawer drawer;
	private Frame frame;
	private int tileSize;
	
	public Tile[][] getTiles(){
		return tiles;
	}
	
	public Map(Tile[][] tiles, TileDrawer drawer, Frame frame, int tileSize) {
		this.drawer = drawer;
		this.tiles = tiles;
		this.frame = frame;
		this.tileSize = tileSize;
	}

	public void draw() {
		Tile[][] framedTiles = frame.tilesInFrame(tiles);
		
		for(int i = 0; i < framedTiles.length; i++){
			for(int j = 0; j < framedTiles[i].length; j++){
				drawer.drawTile(i, j,tileSize, framedTiles[i][j]);
			}
		}
	}

	

}
