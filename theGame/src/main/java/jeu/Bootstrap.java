package jeu;

import org.lwjgl.*;
import org.lwjgl.input.*;
import org.lwjgl.opengl.*;

public class Bootstrap {
    private static final int FPS = 60;
    private static final int DISPLAY_X_SIZE = 1200;
    private static final int DISPLAY_Y_SIZE = 800;

    private boolean running = true;

    private int quad_X_coordinate = 200;
    private int quad_Y_coordinate = 200;
    private int quad_size = 100;

    public void start() {
        createDisplay();
        initOpenGL();

        gameLoop();
        Display.destroy();
    }

    private void createDisplay() {
        try {
            Display.setDisplayMode(new DisplayMode(DISPLAY_X_SIZE, DISPLAY_Y_SIZE));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private void initOpenGL() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, DISPLAY_X_SIZE, 0, DISPLAY_Y_SIZE, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    private void gameLoop() {
        while (!Display.isCloseRequested() && running) {
            pollInput();
            frameLogic();
            drawScreen();
            Display.update();
            Display.sync(FPS);
        }
    }

    private void pollInput() {
        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_SPACE) {
                running = false;
            }
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
            quad_Y_coordinate -= 5;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
            quad_Y_coordinate += 5;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
            quad_X_coordinate += 5;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
            quad_X_coordinate -= 5;
        }

    }

    private void frameLogic() {
        if (quad_X_coordinate - quad_size < 0) {
            quad_X_coordinate = quad_size;
        } else if (quad_X_coordinate + quad_size > DISPLAY_X_SIZE) {
            quad_X_coordinate = DISPLAY_X_SIZE - quad_size;
        } else if (quad_Y_coordinate - quad_size < 0) {
            quad_Y_coordinate = quad_size;
        } else if (quad_Y_coordinate + quad_size > DISPLAY_Y_SIZE) {
            quad_Y_coordinate = DISPLAY_Y_SIZE - quad_size;
        }

    }

    private void drawScreen() {
        // Clear the screen and depth buffer
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

        // set the color of the quad (R,G,B,A)
        GL11.glColor3f(1f, 0.5f, 1.0f);

        // draw quad
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(quad_X_coordinate - quad_size, quad_Y_coordinate - quad_size);
        GL11.glVertex2f(quad_X_coordinate + quad_size, quad_Y_coordinate - quad_size);
        GL11.glVertex2f(quad_X_coordinate + quad_size, quad_Y_coordinate + quad_size);
        GL11.glVertex2f(quad_X_coordinate - quad_size, quad_Y_coordinate + quad_size);
        GL11.glEnd();

    }

    public static void main(String[] argv) {
        Bootstrap displayExample = new Bootstrap();
        displayExample.start();
    }
}
