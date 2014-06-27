package theGame;

import java.util.Random;

import mapGeneration.GridGenerator;
import mapGeneration.display.TileDrawer;
import mapGeneration.noise.FractionnalBrownianMotion;
import mapGeneration.noise.PerlinNoise;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Bootstrap {
	
	public static final int TILE_SIZE = 5;
	public static final int DISPLAY_WIDTH = 1600;
	public static final int DISPLAY_HEIGTH = 800;
	public static final int MAP_WIDTH = DISPLAY_WIDTH/TILE_SIZE;
	public static final int MAP_HEIGTH = DISPLAY_HEIGTH/TILE_SIZE;
	
	TileDrawer drawer = new TileDrawer(TILE_SIZE, 0.4, 0.6);
	PerlinNoise noise = new PerlinNoise(64);
	FractionnalBrownianMotion motion = new FractionnalBrownianMotion(noise, 2, 6);
	GridGenerator generator = new GridGenerator(MAP_WIDTH, MAP_HEIGTH, motion);
 
    public void start() {
        try {
	    Display.setDisplayMode(new DisplayMode(DISPLAY_WIDTH,DISPLAY_HEIGTH));
	    Display.create();
	} catch (LWJGLException e) {
	    e.printStackTrace();
	    System.exit(0);
	}
 
	// init OpenGL
	GL11.glMatrixMode(GL11.GL_PROJECTION);
	GL11.glLoadIdentity();
	GL11.glOrtho(0, DISPLAY_WIDTH, 0, DISPLAY_HEIGTH, 1, -1);
	GL11.glMatrixMode(GL11.GL_MODELVIEW);
	
	double[][] map = generator.generateHeigthMap();
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
	    Display.sync(30);
	}
 
	Display.destroy();
    }
 
    public static void main(String[] argv) {
        Bootstrap quadExample = new Bootstrap();
        quadExample.start();
    }
}
