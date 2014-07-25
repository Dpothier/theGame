package theGame.UI;

import theGame.General.Interval;
import mapGeneration.display.TileDrawer;

public class Map implements Widget{
	
	private Tile[][] tiles;
	private Interval x;
	private Interval y;
	private TileDrawer drawer;
	private Frame frame;
	
	public Tile[][] getTiles(){
		return tiles;
	}
	
	public Map(Tile[][] tiles, TileDrawer drawer, Frame frame) {
		this.drawer = drawer;
		this.tiles = tiles;
		this.frame = frame;
		y = new Interval(0, tiles.length - 1);
		x = new Interval(0, tiles[0].length - 1);
	}

	public void draw() {
		Tile[][] framedTiles = frame.tilesInFrame(tiles);
		for(int i = 0; i < framedTiles.length; i++){
			for(int j = 0; j < framedTiles[i].length; j++){
				drawer.drawTile(i, j, framedTiles[i][j]);
			}
		}
		
	}

	

}
