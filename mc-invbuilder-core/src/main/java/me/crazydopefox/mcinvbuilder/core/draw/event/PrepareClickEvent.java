package me.crazydopefox.mcinvbuilder.core.draw.event;

import me.crazydopefox.mcinvbuilder.core.draw.IWidget;
import me.crazydopefox.mcinvbuilder.core.event.Event;

public class PrepareClickEvent extends Event {
    public PrepareClickEvent(IWidget<?> source) {
        super(source);
    }
}
