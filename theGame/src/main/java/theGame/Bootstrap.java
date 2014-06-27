package theGame;

import java.util.Random;

import mapGeneration.display.TileDrawer;
import mapGeneration.noise.PerlinNoise;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Bootstrap {
	
	public static final int TILE_SIZE = 2;
	public static final int MAP_WIDTH = 400/TILE_SIZE;
	public static final int MAP_HEIGTH = 400/TILE_SIZE;
	
	TileDrawer drawer = new TileDrawer(TILE_SIZE);
	PerlinNoise noise = new PerlinNoise();
 
    public void start() {
        try {
	    Display.setDisplayMode(new DisplayMode(400,400));
	    Display.create();
	} catch (LWJGLException e) {
	    e.printStackTrace();
	    System.exit(0);
	}
 
	// init OpenGL
	GL11.glMatrixMode(GL11.GL_PROJECTION);
	GL11.glLoadIdentity();
	GL11.glOrtho(0, 400, 0, 400, 1, -1);
	GL11.glMatrixMode(GL11.GL_MODELVIEW);
	
	double[][] map = noise.generateHeigthMap(MAP_WIDTH, MAP_HEIGTH,10);
	System.out.println("Generation over");
	
 
	while (!Display.isCloseRequested()) {
	    // Clear the screen and depth buffer
	    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	

		
		for(int i = 0; i < MAP_WIDTH; i++){
			for(int j = 0; j < MAP_HEIGTH; j++){
				drawer.drawTile(i, j, map[i][j]);
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
