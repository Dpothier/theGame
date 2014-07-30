package theGame.UI.Map;

import theGame.General.Interval;
import theGame.UI.Widget;
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
		frame.draw(tiles, drawer, tileSize);
	}
	
	public void moveFrame(int x, int y){
		frame = frame.move(x, y);
	}

	

}
