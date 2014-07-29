package theGame.UI;

public class Zoom {

	private int tileSize;
	private int maximumSize;
	private int minimumSize;

	public Zoom(int initialSize, int maximumSize, int minimumSize) {
		this.tileSize = initialSize;
		this.maximumSize = maximumSize;
		this.minimumSize = minimumSize;
	}

	public int getSize() {
		return tileSize;
	}

	public void zoom() {
		if(tileSize < maximumSize){
			tileSize++;
		}
	}

	public void unzoom() {
		if(tileSize > minimumSize){
			tileSize--;
		}
	}

}
