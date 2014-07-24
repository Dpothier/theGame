package theGame.UI;

import mapGeneration.display.TileDrawer;

public class TileGroup {
	
	private Tile[][] tiles;
	
	public Tile[][] getTiles(){
		return tiles;
	}
	
	public TileGroup(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public TileGroup getSubgroup(int firstX, int firstY, int width, int heigth) {
		checkBounds(firstX, firstY, width, heigth);
		Tile[][] subgroupTiles = extractSubgroup(firstX, firstY, width, heigth);
		return new TileGroup(subgroupTiles);
	}

	private Tile[][] extractSubgroup(int firstX, int firstY, int width, int heigth) {
		Tile[][] subgroupTiles = new Tile[width][heigth];
		for(int i = 0; i < width; i++){
			for(int j = 0; j <heigth; j++){
				subgroupTiles[i][j] = tiles[i + firstX][j + firstY];
			}
		}
		return subgroupTiles;
	}

	private void checkBounds(int firstX, int firstY, int width, int heigth) {
		if(width <= 0 || heigth <= 0){
			throw new EmptySubsetException();
		}
		if(XBoundIsBreached(firstX, width) || YBoundIsBreached(firstY, heigth)){
			throw new SubsetOutOfBoundException();
		}
	}

	private boolean YBoundIsBreached(int firstY, int heigth) {
		return firstY + heigth > tiles[0].length;
	}

	private boolean XBoundIsBreached(int firstX, int width) {
		return firstX + width > tiles.length;
	}

	public void draw(TileDrawer drawer) {
		for(int i = 0; i < tiles.length; i++){
			for(int j = 0; j < tiles[i].length; j++){
				drawer.drawTile(i, j, tiles[i][j]);
			}
		}
		
	}

	

}
