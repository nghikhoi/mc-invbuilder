package me.crazydopefox.mcinvbuilder.core.event;

import lombok.Getter;
import me.crazydopefox.mcinvbuilder.core.draw.IDrawable;

public abstract class Event {

    @Getter private final IDrawable<?> source;

    protected Event(IDrawable<?> source) {
        this.source = source;
    }

}
