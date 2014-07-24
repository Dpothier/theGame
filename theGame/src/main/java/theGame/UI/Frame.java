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
	
	public void move(int x, int y){
		if(canMove(x, y))
		{
			this.x += x;
			this.y += y;
		}
	}

	private boolean canMove(int x, int y) {
		if(this.x + width + x > map.getTiles().length){
			return false;
		}
		if(this.y + heigth + y > map.getTiles()[0].length){
			return false;
		}
		return true;
	}

}
