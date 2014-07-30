package theGame.UI.Triggers;

import org.lwjgl.input.Keyboard;

import theGame.UI.Map.Zoom;
import theGame.engine.input.EventBasedTrigger;
import theGame.engine.input.event.Event;
import theGame.engine.input.event.Peripheral;

public class ZoomingTrigger implements EventBasedTrigger{
	
	private Zoom zoom;

	public ZoomingTrigger(Zoom zoom){
		this.zoom = zoom;
	}

	@Override
	public void reactToEvent(Event event) {
		if(event.peripheral == Peripheral.Keyboard){
			reactToPlusKey(event);
			reactToMinusKey(event);
		}

		
	}

	private void reactToPlusKey(Event event) {
		if(event.button == Keyboard.KEY_A && event.buttonIsPressed){
			zoom.zoom();
		}
		
	}
	
	private void reactToMinusKey(Event event) {
		if(event.button == Keyboard.KEY_Z && event.buttonIsPressed){
			zoom.unzoom();
		}
		
	}

}
