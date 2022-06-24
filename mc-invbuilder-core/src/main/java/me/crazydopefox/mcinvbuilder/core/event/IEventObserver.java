package me.crazydopefox.mcinvbuilder.core.event;

import me.crazydopefox.mcinvbuilder.core.draw.DrawHolder;

public interface IEventObserver<E extends IEvent> {

    void onEvent(DrawHolder<?> holder, E event);

}
