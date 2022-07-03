package me.crazydopefox.mcinvbuilder.core.event;

import me.crazydopefox.mcinvbuilder.core.draw.IWidget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestEventSource {

    class AEvent extends Event {
        protected AEvent(IWidget<?> source) {
            super(source);
        }
    }

    class BEvent extends Event {
        protected BEvent(IWidget<?> source) {
            super(source);
        }
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
        source.notifyObservers(null, new AEvent(null));
        Assertions.assertTrue(fired[0]);
        Assertions.assertTrue(fired[2]);

        fired[2] = false;
        source.notifyObservers(null, new BEvent(null));
        Assertions.assertTrue(fired[1]);
        Assertions.assertTrue(fired[2]);
    }

}
