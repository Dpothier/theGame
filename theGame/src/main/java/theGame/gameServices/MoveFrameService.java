package theGame.gameServices;

import theGame.UI.Map.Frame;

public class MoveFrameService {
	
    private int xspeed;
    private int yspeed;

    private Frame frame;

    public MoveFrameService(Frame frame) {
        this.frame= frame;
    }

    public void accelerate(int xspeed, int yspeed) {
        this.xspeed += xspeed;
        this.yspeed += yspeed;
    }
    
    public void deccelerate(int xspeed, int yspeed){
    	this.xspeed -= xspeed;
    	this.yspeed -= yspeed;
    }

    public void stop() {
        xspeed = 0;
        yspeed = 0;

    }

    public void move() {
        frame.move(xspeed, yspeed);
    }

}
