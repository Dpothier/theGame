package theGame.gameServices;

import theGame.UI.Frame;
import jeu.quadsAdventure.gameService.Position;

public class MoveFrameService {
	
    private int xspeed;
    private int yspeed;

    private int x;
    private int y;
    private Frame frame;

    public MoveFrameService(Frame frame) {
        this.frame= frame;
    }

    public void setSpeed(int xspeed, int yspeed) {
        this.xspeed = xspeed;
        this.yspeed = yspeed;
    }

    public void stop() {
        xspeed = 0;
        yspeed = 0;

    }

    public void move() {
        frame.move(xspeed, yspeed);
    }

}
