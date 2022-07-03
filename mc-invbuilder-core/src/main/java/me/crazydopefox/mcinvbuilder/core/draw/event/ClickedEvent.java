package me.crazydopefox.mcinvbuilder.core.draw.event;

import me.crazydopefox.mcinvbuilder.core.draw.IWidget;
import me.crazydopefox.mcinvbuilder.core.event.Event;

public class ClickedEvent extends Event {
    public ClickedEvent(IWidget<?> source) {
        super(source);
    }
}
