package theGame.UI.Triggers;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lwjgl.input.Keyboard;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import theGame.UI.Map.Zoom;
import theGame.engine.input.event.Event;
import theGame.engine.input.event.Peripheral;

@RunWith(MockitoJUnitRunner.class)
public class ZoomingTriggerTest {
	
	@Mock
	Zoom zoom;
	
	ZoomingTrigger trigger;
	
	@Before
	public void SetUp(){
		trigger = new ZoomingTrigger(zoom);
	}
	
	@Test
	public void Pressing_A_Key_Zooms(){
		Event event = new Event(Peripheral.Keyboard, Keyboard.KEY_A, true);
		
		trigger.reactToEvent(event);
		
		verify(zoom).zoom();
	}
	
	@Test
	public void Pressing_Z_Key_Zooms(){
		Event event = new Event(Peripheral.Keyboard, Keyboard.KEY_Z, true);
		
		trigger.reactToEvent(event);
		
		verify(zoom).unzoom();;
	}

}
