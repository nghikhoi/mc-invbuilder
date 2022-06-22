package me.crazydopefox.mcinvbuilder.core.event;

import me.crazydopefox.mcinvbuilder.core.IDrawHolder;

public interface IEventObserver<E extends IEvent> {

    void onEvent(IDrawHolder holder, E event);

}
