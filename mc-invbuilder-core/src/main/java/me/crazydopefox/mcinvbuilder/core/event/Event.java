package me.crazydopefox.mcinvbuilder.core.event;

import lombok.Getter;
import me.crazydopefox.mcinvbuilder.core.draw.IWidget;

public abstract class Event {

    @Getter private final IWidget<?> source;

    protected Event(IWidget<?> source) {
        this.source = source;
    }

}
