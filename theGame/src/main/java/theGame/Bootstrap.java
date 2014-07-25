package theGame;


import mapGeneration.GridGenerator;
import mapGeneration.display.TileDrawer;
import mapGeneration.noise.FractionnalBrownianMotion;
import mapGeneration.noise.PerlinNoise;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import theGame.General.Interval;
import theGame.UI.Frame;
import theGame.UI.Map;
import theGame.UI.Triggers.ArrowTrigger;
import theGame.engine.input.EventManager;
import theGame.engine.input.EventPoller;
import theGame.gameServices.MoveFrameService;

public class Bootstrap {
	
	public static final int TILE_SIZE = 2;
	public static final int DISPLAY_WIDTH = 640;
	public static final int DISPLAY_HEIGTH = 480;
	public static final int MAP_WIDTH = 800;
	public static final int MAP_HEIGTH = 800;
	
	TileDrawer drawer = new TileDrawer(TILE_SIZE, 0.5);
	PerlinNoise noise = new PerlinNoise(256);
	FractionnalBrownianMotion motion = new FractionnalBrownianMotion(noise, 2, 12);
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
	
	Frame frame = new Frame(new Interval(0, DISPLAY_WIDTH - 1),new Interval(0, DISPLAY_HEIGTH - 1), new Interval(0, MAP_WIDTH - 1), new Interval(0, MAP_HEIGTH - 1));
	Map map = new Map(generator.generateHeigthMap(),drawer, frame);
	
	EventManager eventManager = new EventManager(new EventPoller());
	MoveFrameService service = new MoveFrameService(frame);
	eventManager.registerTrigger(new ArrowTrigger(service, 5));
	System.out.println("Generation over");
	
 
	while (!Display.isCloseRequested()) {
	    // Clear the screen and depth buffer
	    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	

	    eventManager.manageEvents();
	    service.move();
		map.draw();
 
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
