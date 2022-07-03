package me.crazydopefox.mcinvbuilder.core.draw.event;

import lombok.Getter;
import me.crazydopefox.mcinvbuilder.core.draw.IWidget;
import me.crazydopefox.mcinvbuilder.core.event.Event;

public class SizeChangedEvent extends Event {

    @Getter private final int oldHeight, newHeight, oldWidth, newWidth;

    public SizeChangedEvent(IWidget<?> source, int oldHeight, int newHeight, int oldWidth, int newWidth) {
        super(source);
        this.oldHeight = oldHeight;
        this.newHeight = newHeight;
        this.oldWidth = oldWidth;
        this.newWidth = newWidth;
    }

}
