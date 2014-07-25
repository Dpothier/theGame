package jeu.quadsAdventure.gameService;

public class MoveQuadService {

    private int xspeed;
    private int yspeed;

    private Position position;

    public MoveQuadService(Position initialPosition) {
        this.position = initialPosition;
    }

    public void setQuadSpeed(int xspeed, int yspeed) {
        this.xspeed = xspeed;
        this.yspeed = yspeed;
    }

    public void stop() {
        xspeed = 0;
        yspeed = 0;

    }

    public void move() {
        position = position.move(xspeed, yspeed);
    }

    public Position getCoordinates() {
        return position;
    }

}
