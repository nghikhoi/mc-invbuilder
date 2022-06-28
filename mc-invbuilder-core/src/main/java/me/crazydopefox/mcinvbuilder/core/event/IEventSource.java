package me.crazydopefox.mcinvbuilder.core.event;

import me.crazydopefox.mcinvbuilder.core.draw.DrawHolder;

public interface IEventSource {

    <T extends Event> void addObserver(Class<T> clazz, IEventObserver<? super T> observer);

    <T extends Event> void removeObserver(Class<T> clazz, IEventObserver<? super T> observer);

    <T extends Event> void notifyObservers(DrawHolder<?> holder, T event);

}
