package jeu.quadsAdventure.gameService;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position move(int x, int y) {
        return new Position(this.x + x, this.y + y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
