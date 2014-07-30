package theGame.UI.Triggers;

import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lwjgl.input.Keyboard;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import theGame.engine.input.event.Event;
import theGame.engine.input.event.Peripheral;
import theGame.gameServices.MoveFrameService;

@RunWith(MockitoJUnitRunner.class)
public class ArrowTriggerTest {
	private static final int A_SPEED = 5;

	@Mock
	private MoveFrameService service;
	
	ArrowTrigger trigger;
	
	@Before
	public void setUp(){
		trigger = new ArrowTrigger(service, A_SPEED);
	}
	
	@Test
	public void Pressing_Up_Key_Accelerate_In_Positive_Y(){
		Event event = new Event(Peripheral.Keyboard, Keyboard.KEY_UP, true, 0, 0, 0, 0);
		
		trigger.reactToEvent(event);
		
		verify(service).accelerate(0, A_SPEED);
	}
	
	@Test
	public void Releasing_Up_Key_Deccelarate_In_Positive_Y(){
		Event event = new Event(Peripheral.Keyboard, Keyboard.KEY_UP, false, 0,0,0,0);
		
		trigger.reactToEvent(event);
		
		verify(service).deccelerate(0, A_SPEED);
	}
	
	@Test
	public void Pressing_Down_Key_Accelerate_In_Negative_Y(){
		Event event = new Event(Peripheral.Keyboard, Keyboard.KEY_DOWN, true, 0, 0, 0, 0);
		
		trigger.reactToEvent(event);
		
		verify(service).accelerate(0, -A_SPEED);
	}
	
	@Test
	public void Releasing_Down_Key_Deccelarate_In_Negative_Y(){
		Event event = new Event(Peripheral.Keyboard, Keyboard.KEY_DOWN, false, 0,0,0,0);
		
		trigger.reactToEvent(event);
		
		verify(service).deccelerate(0, -A_SPEED);
	}
	
	@Test
	public void Pressing_Right_Key_Accelerate_In_Positive_X(){
		Event event = new Event(Peripheral.Keyboard, Keyboard.KEY_RIGHT, true);
		
		trigger.reactToEvent(event);
		
		verify(service).accelerate(A_SPEED, 0);
	}
	
	@Test
	public void Releasing_Right_Key_Deccelarate_In_Positive_X(){
		Event event = new Event(Peripheral.Keyboard, Keyboard.KEY_RIGHT, false);
		
		trigger.reactToEvent(event);
		
		verify(service).deccelerate(A_SPEED, 0);
	}
	
	@Test
	public void Pressing_Left_Key_Accelerate_In_Negative_X(){
		Event event = new Event(Peripheral.Keyboard, Keyboard.KEY_LEFT, true);
		
		trigger.reactToEvent(event);
		
		verify(service).accelerate(-A_SPEED, 0);
	}
	
	@Test
	public void Releasing_Left_Key_Deccelarate_In_Negative_X(){
		Event event = new Event(Peripheral.Keyboard, Keyboard.KEY_LEFT, false);
		
		trigger.reactToEvent(event);
		
		verify(service).deccelerate(-A_SPEED, 0);
	}
}
