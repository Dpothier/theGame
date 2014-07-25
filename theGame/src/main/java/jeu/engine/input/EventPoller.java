package jeu.engine.input;

import java.util.*;

import jeu.engine.input.event.*;
import jeu.engine.input.exception.*;

import org.lwjgl.input.*;

public class EventPoller {

    LinkedList<Event> polledEventsQueue;

    public EventPoller() {
        polledEventsQueue = new LinkedList<>();
    }

    public void pollEvents() {
        while (Keyboard.next()) {
            polledEventsQueue.add(new Event(Peripheral.Keyboard, Keyboard.getEventKey(), Keyboard.getEventKeyState(),
                    0, 0, 0, 0));
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
