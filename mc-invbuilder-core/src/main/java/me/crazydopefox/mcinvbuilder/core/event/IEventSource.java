package me.crazydopefox.mcinvbuilder.core.event;

import me.crazydopefox.mcinvbuilder.core.draw.DrawHolder;

public interface IEventSource {

    <T extends IEvent> void addObserver(Class<T> clazz, IEventObserver<? super T> observer);

    <T extends IEvent> void removeObserver(Class<T> clazz, IEventObserver<? super T> observer);

    <T extends IEvent> void notifyObservers(DrawHolder<?> holder, T event);

}
