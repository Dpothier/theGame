package jeu.engine.input;

import java.util.*;

import jeu.engine.input.event.*;

public class EventManager {

    List<EventBasedTrigger> eventTriggers;
    private EventPoller poller;

    public EventManager(EventPoller poller) {
        this.poller = poller;
        eventTriggers = new ArrayList<>();
    }

    public void manageEvents() {
        poller.pollEvents();
        while (poller.hasEvent()) {
            Event event = poller.popEvent();
            checkTriggers(event);
        }

    }

    private void checkTriggers(Event event) {
        for (EventBasedTrigger trigger : eventTriggers) {
            trigger.reactToEvent(event);
        }
    }

    public void registerTrigger(EventBasedTrigger trigger) {
        eventTriggers.add(trigger);

    }
}
