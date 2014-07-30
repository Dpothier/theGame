package theGame.engine.input.event;

public class Event {

    public Event(Peripheral peripheral, int button, boolean buttonIsPressed, int mouse_x, int mouse_y, int mouse_dx,
            int mouse_dy) {
        this.peripheral = peripheral;
        this.button = button;
        this.buttonIsPressed = buttonIsPressed;
        this.mouse_x = mouse_x;
        this.mouse_y = mouse_y;
        this.mouse_dx = mouse_dx;
        this.mouse_dy = mouse_dy;
    }
    
    public Event(Peripheral peripheral, int button, boolean buttonIsPressed){
    	this(peripheral, button, buttonIsPressed,0,0,0,0);
    }

    public Peripheral peripheral;

    public int button;
    public boolean buttonIsPressed;

    public int mouse_x;
    public int mouse_y;

    public int mouse_dx;
    public int mouse_dy;

}
