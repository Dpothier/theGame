package jeu.quadsAdventure.triggers;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import jeu.engine.input.event.*;
import jeu.quadsAdventure.gameService.*;

import org.junit.*;
import org.junit.runner.*;
import org.lwjgl.input.*;
import org.mockito.*;
import org.mockito.runners.*;

@RunWith(MockitoJUnitRunner.class)
public class ArrowTriggerTest {

    private static final int QUADS_SPEED = 5;

    @Mock
    MoveQuadService moveService;

    ArrowTrigger trigger;

    @Before
    public void setUp() {
        trigger = new ArrowTrigger(moveService, QUADS_SPEED);
    }

    @Test
    public void when_down_key_is_pressed_moveService_is_called_to_move_down_at_QUADS_SPEED() {
        Event pressingDownKeyEvent = new Event(Peripheral.Keyboard, Keyboard.KEY_DOWN, true, 0, 0, 0, 0);

        trigger.reactToEvent(pressingDownKeyEvent);

        verify(moveService).setQuadSpeed(0, -QUADS_SPEED);
    }

    @Test
    public void when_up_key_is_pressed_moveService_is_called_to_move_up_at_QUADS_SPEED() {
        Event pressingUpKeyEvent = new Event(Peripheral.Keyboard, Keyboard.KEY_UP, true, 0, 0, 0, 0);

        trigger.reactToEvent(pressingUpKeyEvent);

        verify(moveService).setQuadSpeed(0, QUADS_SPEED);
    }

    @Test
    public void when_left_key_is_pressed_moveService_is_called_to_move_left_at_QUADS_SPEED() {
        Event pressingLeftKeyEvent = new Event(Peripheral.Keyboard, Keyboard.KEY_LEFT, true, 0, 0, 0, 0);

        trigger.reactToEvent(pressingLeftKeyEvent);

        verify(moveService).setQuadSpeed(-QUADS_SPEED, 0);
    }

    @Test
    public void when_rigth_key_is_pressed_moveService_is_called_to_move_rigth_at_QUADS_SPEED() {
        Event pressingRigthKeyEvent = new Event(Peripheral.Keyboard, Keyboard.KEY_RIGHT, true, 0, 0, 0, 0);

        trigger.reactToEvent(pressingRigthKeyEvent);

        verify(moveService).setQuadSpeed(QUADS_SPEED, 0);
    }

    @Test
    public void when_key_is_released_moveService_is_called_to_stop_quads() {
        Event releasingArrowKeyEvent = new Event(Peripheral.Keyboard, Keyboard.KEY_UP, false, 0, 0, 0, 0);

        trigger.reactToEvent(releasingArrowKeyEvent);

        verify(moveService).stop();
    }

    @Test
    public void when_any_key_is_pressed_moveService_is_not_called() {
        Event pressingAnyKeyEvent = new Event(Peripheral.Keyboard, Keyboard.KEY_0, true, 0, 0, 0, 0);

        trigger.reactToEvent(pressingAnyKeyEvent);

        verify(moveService, never()).setQuadSpeed(anyInt(), anyInt());
        verify(moveService, never()).stop();
    }

    @Test
    public void when_any_key_is_released_moveService_is_not_called() {
        Event releasingAnyKeyEvent = new Event(Peripheral.Keyboard, Keyboard.KEY_0, false, 0, 0, 0, 0);

        trigger.reactToEvent(releasingAnyKeyEvent);

        verify(moveService, never()).setQuadSpeed(anyInt(), anyInt());
        verify(moveService, never()).stop();

    }
}
