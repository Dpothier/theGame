package theGame.UI;

import theGame.General.Interval;
import mapGeneration.display.TileDrawer;

public class Map {
	
	private Tile[][] tiles;
	private Interval x;
	private Interval y;
	
	public Tile[][] getTiles(){
		return tiles;
	}
	
	public Map(Tile[][] tiles) {
		this.tiles = tiles;
		y = new Interval(0, tiles.length - 1);
		x = new Interval(0, tiles[0].length - 1);
	}

	public Map getSubmap(Interval x, Interval y) {
		checkBounds(x, y);
		Tile[][] subgroupTiles = extractSubmap(x,y);
		return new Map(subgroupTiles);
	}

	private Tile[][] extractSubmap(Interval x, Interval y) {
		Tile[][] submapTiles = new Tile[x.distance() + 1][y.distance() + 1];
		for(int i = 0; i < x.distance() + 1; i++){
			for(int j = 0; j < y.distance() + 1; j++){
				submapTiles[i][j] = tiles[i + x.getStartPoint()][j + y.getStartPoint()];
			}
		}
		return submapTiles;
	}

	private void checkBounds(Interval x, Interval y) {
		if(!(this.x.contains(x) && this.y.contains(y))) {
			throw new SubsetOutOfBoundException();
		}
	}

	public void draw(TileDrawer drawer) {
		for(int i = 0; i < tiles.length; i++){
			for(int j = 0; j < tiles[i].length; j++){
				drawer.drawTile(i, j, tiles[i][j]);
			}
		}
		
	}

	

}
