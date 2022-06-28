package me.crazydopefox.mcinvbuilder.core.draw.event;

import me.crazydopefox.mcinvbuilder.core.draw.IDrawable;
import me.crazydopefox.mcinvbuilder.core.event.Event;

public class SizeChangedEvent extends Event {

    public SizeChangedEvent(IDrawable<?> source) {
        super(source);
    }

}
