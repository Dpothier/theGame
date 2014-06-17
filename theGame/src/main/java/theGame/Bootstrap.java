package theGame;

import java.util.Random;

import mapGeneration.display.TileDrawer;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Bootstrap {
	
	public static final int TILE_SIZE = 5;
	public static final int MAP_WIDTH = 800/TILE_SIZE;
	public static final int MAP_HEIGTH = 600/TILE_SIZE;
	
	TileDrawer drawer = new TileDrawer(TILE_SIZE);
 
    public void start() {
        try {
	    Display.setDisplayMode(new DisplayMode(800,600));
	    Display.create();
	} catch (LWJGLException e) {
	    e.printStackTrace();
	    System.exit(0);
	}
 
	// init OpenGL
	GL11.glMatrixMode(GL11.GL_PROJECTION);
	GL11.glLoadIdentity();
	GL11.glOrtho(0, 800, 0, 600, 1, -1);
	GL11.glMatrixMode(GL11.GL_MODELVIEW);
	
	Random random = new Random();
	int[][] multi = new int[MAP_WIDTH][MAP_HEIGTH];
	for(int i = 0; i < MAP_WIDTH; i++){
		for(int j = 0; j < MAP_HEIGTH; j++){
			multi[i][j] = random.nextInt(256);
		}
	}
	
 
	while (!Display.isCloseRequested()) {
	    // Clear the screen and depth buffer
	    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
		
	    drawer.drawTile(200, 200, 120);
		
		GL11.glEnd();
		
		for(int i = 0; i < MAP_WIDTH; i++){
			for(int j = 0; j < MAP_HEIGTH; j++){
				drawer.drawTile(i, j, multi[i][j]);
			}
		}
 
	    Display.update();
	}
 
	Display.destroy();
    }
 
    public static void main(String[] argv) {
        Bootstrap quadExample = new Bootstrap();
        quadExample.start();
    }
}
