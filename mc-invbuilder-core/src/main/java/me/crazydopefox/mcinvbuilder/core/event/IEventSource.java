package me.crazydopefox.mcinvbuilder.core.event;

import me.crazydopefox.mcinvbuilder.core.IDrawHolder;

public interface IEventSource {

    <T extends IEvent> void addObserver(Class<T> clazz, IEventObserver<? super T> observer);

    <T extends IEvent> void removeObserver(Class<T> clazz, IEventObserver<? super T> observer);

    <T extends IEvent> void notifyObservers(IDrawHolder holder, T event);

}
