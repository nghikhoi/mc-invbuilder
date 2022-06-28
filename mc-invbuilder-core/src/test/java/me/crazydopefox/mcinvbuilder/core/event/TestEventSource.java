package me.crazydopefox.mcinvbuilder.core.event;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestEventSource {

    class AEvent implements Event {
    }

    class BEvent implements Event {
    }

    @Test
    void testEventSource() {
        EventSource source = new EventSource();
        boolean[] fired = {false, false, false};
        source.addObserver(AEvent.class, (holder, event) -> {
            fired[0] = true;
        });
        source.addObserver(BEvent.class, (holder, event) -> {
            fired[1] = true;
        });
        source.addObserver(Event.class, (holder, event) -> {
            fired[2] = true;
        });
        source.notifyObservers(null, new AEvent());
        Assertions.assertTrue(fired[0]);
        Assertions.assertTrue(fired[2]);

        fired[2] = false;
        source.notifyObservers(null, new BEvent());
        Assertions.assertTrue(fired[1]);
        Assertions.assertTrue(fired[2]);

    }

}
