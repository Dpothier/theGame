package mapGeneration.display;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import theGame.UI.Tile;

public class TileDrawer {
	
	private double waterLevel;

	public TileDrawer(int tileSize, double waterLevel) {
		this.waterLevel = waterLevel;
	}

	public void drawTile(int tileColumn, int tileRow,int tileSize, Tile tile){
		int tileStartX = tileColumn * tileSize;
		int tileStartY = tileRow * tileSize;
		
		if(tile.heigth<= waterLevel){
			setWaterColor((int)(tile.heigth*255));
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(tileStartX,tileStartY);
			GL11.glVertex2f(tileStartX + tileSize,tileStartY);
			GL11.glVertex2f(tileStartX + tileSize, tileStartY + tileSize);
			GL11.glVertex2f(tileStartX, tileStartY + tileSize);
			GL11.glEnd();
		}
		else{
			setGrassLandColor((int)(tile.heigth*255));
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(tileStartX,tileStartY);
			GL11.glVertex2f(tileStartX + tileSize,tileStartY);
			GL11.glVertex2f(tileStartX + tileSize, tileStartY + tileSize);
			GL11.glVertex2f(tileStartX, tileStartY + tileSize);
			GL11.glEnd();
		}	
	}

	private void setGrassLandColor(int value) {
		float[] hsv = new float[3];
		Color.RGBtoHSB(value, value, value, hsv);
		hsv[0] = (float)130/360;
		hsv[1] = (float) 1;
		hsv[2] -= 0.15;
		Color waterColor = Color.getHSBColor(hsv[0], hsv[1], hsv[2]);

		float red = ((float)waterColor.getRed())/255;
		double green = ((float)waterColor.getGreen())/255;
		double blue = ((float)waterColor.getBlue()/255);
		//System.out.println("red: " + red + " green: " + green + " blue: " + blue);
		GL11.glColor3d(red,green,blue);
		
	}

	private void setWaterColor(int value) {
		float[] hsv = new float[3];
		Color.RGBtoHSB(value, value, value, hsv);
		hsv[0] = (float)200/360;
		hsv[1] = (float) 1;
		hsv[2] += 0.1;
		Color waterColor = Color.getHSBColor(hsv[0], hsv[1], hsv[2]);

		float red = ((float)waterColor.getRed())/255;
		double green = ((float)waterColor.getGreen())/255;
		double blue = ((float)waterColor.getBlue()/255);
		//System.out.println("red: " + red + " green: " + green + " blue: " + blue);
		GL11.glColor3d(red,green,blue);
	}

}
