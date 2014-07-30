package theGame.engine.input;

import java.util.*;

import org.lwjgl.input.*;

import theGame.engine.input.event.*;
import theGame.engine.input.exception.*;

public class EventPoller {

    LinkedList<Event> polledEventsQueue;

    public EventPoller() {
        polledEventsQueue = new LinkedList<>();
    }

    public void pollEvents() {
        while (Keyboard.next()) {
            polledEventsQueue.add(new Event(Peripheral.Keyboard, Keyboard.getEventKey(), Keyboard.getEventKeyState()));
        }
        while (Mouse.next()) {
            polledEventsQueue.add(new Event(Peripheral.Mouse, Mouse.getEventButton(), Mouse.getEventButtonState(),
                    Mouse.getEventX(), Mouse.getEventY(), Mouse.getEventDX(), Mouse.getEventDY()));
        }
    }

    public Event popEvent() {
        if (!hasEvent()) {
            throw new NoEventException("EventPoller is asked to pop when there is no event to pop");
        }
        return polledEventsQueue.pop();
    }

    public boolean hasEvent() {

        return !polledEventsQueue.isEmpty();
    }
}
