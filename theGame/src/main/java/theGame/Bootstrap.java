package theGame;


import mapGeneration.GridGenerator;
import mapGeneration.display.TileDrawer;
import mapGeneration.noise.FractionnalBrownianMotion;
import mapGeneration.noise.PerlinNoise;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import theGame.General.BoundedInterval;
import theGame.General.Interval;
import theGame.General.Rectangle;
import theGame.UI.Map.Frame;
import theGame.UI.Map.Map;
import theGame.UI.Map.Zoom;
import theGame.UI.Triggers.ArrowTrigger;
import theGame.UI.Triggers.ZoomingTrigger;
import theGame.engine.input.EventManager;
import theGame.engine.input.EventPoller;
import theGame.gameServices.MoveFrameService;

public class Bootstrap {
	
	public static final int TILE_SIZE = 2;
	public static final int DISPLAY_WIDTH = 640;
	public static final int DISPLAY_HEIGTH = 480;
	public static final int MAP_WIDTH = 800;
	public static final int MAP_HEIGTH = 800;
	
	public static final int INITIAL_TILE_SIZE = 5;
	public static final int MAXIMUM_TILE_SIZE = 10;
	public static final int MINIMUM_TILE_SIZE = 2;
	
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
	Zoom zoom = new Zoom(INITIAL_TILE_SIZE,MINIMUM_TILE_SIZE,MAXIMUM_TILE_SIZE);
	Rectangle position = new Rectangle(new BoundedInterval(new Interval(0, MAP_WIDTH -1), 0, DISPLAY_WIDTH - 1),new BoundedInterval(new Interval(0, MAP_HEIGTH -1), 0, DISPLAY_HEIGTH - 1));
	Frame frame = new Frame(position, zoom);
	Map map = new Map(generator.generateHeigthMap(),drawer, frame, TILE_SIZE);
	
	EventManager eventManager = new EventManager(new EventPoller());
	MoveFrameService service = new MoveFrameService(frame);
	eventManager.registerTrigger(new ArrowTrigger(service, 5));
	eventManager.registerTrigger(new ZoomingTrigger(zoom));
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
