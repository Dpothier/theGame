package mapGeneration.display;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

public class TileDrawer {
	
	private int tileSize;
	private double waterLevel;
	private double mountainLevel;

	public TileDrawer(int tileSize, double waterLevel, double mountainLevel) {
		this.tileSize = tileSize;
		this.waterLevel = waterLevel;
		this.mountainLevel = mountainLevel;
	}

	public void drawTile(int tileColumn, int tileRow, double value){
		int tileStartX = tileColumn * tileSize;
		int tileStartY = tileRow * tileSize;
		
		if(value <= waterLevel){
			setWaterColor((int)(value*255));
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(tileStartX,tileStartY);
			GL11.glVertex2f(tileStartX + tileSize,tileStartY);
			GL11.glVertex2f(tileStartX + tileSize, tileStartY + tileSize);
			GL11.glVertex2f(tileStartX, tileStartY + tileSize);
			GL11.glEnd();
		}
		else if(value >= mountainLevel){
			setMoutainColor((int)(value*255));
		}
		else{
			setGrassLandColor((int)(value*255));
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(tileStartX,tileStartY);
			GL11.glVertex2f(tileStartX + tileSize,tileStartY);
			GL11.glVertex2f(tileStartX + tileSize, tileStartY + tileSize);
			GL11.glVertex2f(tileStartX, tileStartY + tileSize);
			GL11.glEnd();
		}
		
		
	}

	private void setMoutainColor(int i) {
		
		
	}

	private void setGrassLandColor(int value) {
		float[] hsv = new float[3];
		Color.RGBtoHSB(value, value, value, hsv);
		hsv[0] = (float)130/360;
		hsv[1] = (float) 1;
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

	private void setDeepWaterColor() {
		double red = 12.0/255.0;
		double green = 16.0/255.0;
		double blue = 138.0/255.0;
		GL11.glColor3d(red,green,blue);
		
		
	}

}
