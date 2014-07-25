package theGame.UI;

import theGame.General.Interval;

public class Frame {
	
	private Interval width;
	private Interval heigth;

	private Map map;
	
	public Frame(Map map,Interval width, Interval heigth) {
		this.map = map;
		this.width = width;
		this.heigth = heigth;
	}

	public void display() {
		Map framedMap = map.getSubmap(width, heigth);
		framedMap.draw();
	}
	
	public void move(int x, int y){
		if(canMove(x, y))
		{
			width = width.move(x);
			heigth = heigth.move(y);
		}
	}

	private boolean canMove(int x, int y) {
		if(width.move(x).getStartPoint() < 0){
			return false;
		}
		if(heigth.move(y).getStartPoint() < 0){
			return false;
		}
		if(width.move(x).getEndPoint()  > map.getTiles().length){
			return false;
		}
		if(heigth.move(y).getEndPoint() > map.getTiles()[0].length){
			return false;
		}
		return true;
	}

}
