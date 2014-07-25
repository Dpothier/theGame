package theGame.UI;

import org.mockito.Mock;

import theGame.General.Interval;
import mapGeneration.display.TileDrawer;

public class Frame {
	
	private Interval width;
	private Interval heigth;

	private Map map;
	private TileDrawer tileDrawer;
	
	public Frame(Map map, TileDrawer tileDrawer, Interval width, Interval heigth) {
		this.map = map;
		this.tileDrawer = tileDrawer;
		this.width = width;
		this.heigth = heigth;
	}

	public void display() {
		Map framedMap = map.getSubmap(width, heigth);
		framedMap.draw(tileDrawer);
	}
	
	public void move(int x, int y){
		if(canMove(x, y))
		{
			width = width.move(x);
			heigth = heigth.move(y);
		}
	}

	private boolean canMove(int x, int y) {
		if(width.move(x).getEndPoint()  > map.getTiles().length){
			return false;
		}
		if(heigth.move(y).getEndPoint() > map.getTiles()[0].length){
			return false;
		}
		return true;
	}

}
