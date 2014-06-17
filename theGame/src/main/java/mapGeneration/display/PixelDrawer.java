package mapGeneration.display;

import org.lwjgl.opengl.GL11;

public class PixelDrawer {
	
	public void drawPixel(int x, int y, float shadeOfGrey){
		GL11.glColor3f(shadeOfGrey/255,shadeOfGrey/255,shadeOfGrey/255);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(x,y);
		GL11.glEnd();
	}

}
