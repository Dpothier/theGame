package mapGeneration.display;

import org.lwjgl.opengl.GL11;

public class TileDrawer {
	
	private int tileSize;

	public TileDrawer(int tileSize) {
		this.tileSize = tileSize;
	}

	public void drawTile(int tileColumn, int tileRow, float value){
		float shadeOfGrey = value / 255;
		int tileStartX = tileColumn * tileSize;
		int tileStartY = tileRow * tileSize;
		
		GL11.glColor3d(shadeOfGrey,shadeOfGrey,shadeOfGrey);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(tileStartX,tileStartY);
		GL11.glVertex2f(tileStartX + tileSize,tileStartY);
		GL11.glVertex2f(tileStartX + tileSize, tileStartY + tileSize);
		GL11.glVertex2f(tileStartX, tileStartY + tileSize);
		GL11.glEnd();
	}

}
