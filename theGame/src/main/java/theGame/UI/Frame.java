package theGame.UI;

import mapGeneration.display.TileDrawer;

public class Frame {
	
	private int x = 0;
	private int y = 0;
	private TileGroup map;
	private TileDrawer tileDrawer;
	private int width;
	private int heigth;
	
	public Frame(TileGroup map, TileDrawer tileDrawer, int width, int heigth) {
		this.map = map;
		this.tileDrawer = tileDrawer;
		this.width = width;
		this.heigth = heigth;
	}

	public void display() {
		TileGroup framedMap = map.getSubgroup(x, y, width, heigth);
		framedMap.draw(tileDrawer);
	}

}
