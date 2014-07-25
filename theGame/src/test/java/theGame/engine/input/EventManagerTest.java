package theGame.engine.input;

import static org.mockito.Mockito.*;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.runners.*;

import theGame.engine.input.event.*;
import theGame.engine.input.exception.*;

@RunWith(MockitoJUnitRunner.class)
public class EventManagerTest {

    @Mock
    private EventBasedTrigger firstTrigger, secondTrigger;

    @Mock
    private EventPoller poller;
    @Mock
    private Event firstEvent, secondEvent;

    private EventManager eventManager;

    @Before
    public void setUp() {
        eventManager = new EventManager(poller);

    }

    @Test
    public void manageEvents_asks_poller_to_poll_events() {
        noEventIsPending();
        noTriggerIsRegistred();
        eventManager.manageEvents();
        verify(poller).pollEvents();
    }

    @Test
    public void if_no_event_is_pending_do_not_pop_event() {
        noEventIsPending();
        noTriggerIsRegistred();
        eventManager.manageEvents();
        verify(poller, never()).popEvent();
    }

    @Test
    public void if_a_single_event_is_pending_registred_trigger_reacts_during_manageEvents() {
        aSingleEventIsPending();
        oneTriggerIsRegistred();
        eventManager.manageEvents();
        verify(firstTrigger).reactToEvent(firstEvent);
    }

    @Test
    public void if_two_triggers_are_registred_each_reacts_during_manageEvents() {
        aSingleEventIsPending();
        twoTriggersAreRegistred();

        eventManager.manageEvents();

        verify(firstTrigger).reactToEvent(firstEvent);
        verify(secondTrigger).reactToEvent(firstEvent);
    }

    @Test
    public void if_two_events_are_pending_every_registred_trigger_reacts_to_every_pending_events() {
        twoEventsArePending();
        twoTriggersAreRegistred();

        eventManager.manageEvents();

        verify(firstTrigger).reactToEvent(firstEvent);
        verify(secondTrigger).reactToEvent(firstEvent);
        verify(firstTrigger).reactToEvent(secondEvent);
        verify(secondTrigger).reactToEvent(secondEvent);

    }

    private void noTriggerIsRegistred() {

    }

    private void oneTriggerIsRegistred() {
        eventManager.registerTrigger(firstTrigger);
    }

    private void twoTriggersAreRegistred() {
        eventManager.registerTrigger(firstTrigger);
        eventManager.registerTrigger(secondTrigger);
    }

    private void noEventIsPending() {
        when(poller.popEvent()).thenThrow(new NoEventException("No event was pending"));
        when(poller.hasEvent()).thenReturn(false);

    }

    private void aSingleEventIsPending() {
        when(poller.popEvent()).thenReturn(firstEvent);
        when(poller.hasEvent()).thenReturn(true).thenReturn(false);
    }

    private void twoEventsArePending() {
        when(poller.popEvent()).thenReturn(firstEvent).thenReturn(secondEvent);
        when(poller.hasEvent()).thenReturn(true).thenReturn(true).thenReturn(false);

    }
}
