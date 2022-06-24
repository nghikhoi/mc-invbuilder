package me.crazydopefox.mcinvbuilder.core.event;

import me.crazydopefox.mcinvbuilder.core.draw.DrawHolder;

import java.util.Map;

public class EventSource implements IEventSource {

    private Map<Class<? extends IEvent>, IEventObserver<? extends IEvent>[]> observers;

    @Override
    public <T extends IEvent> void addObserver(Class<T> clazz, IEventObserver<? super T> observer) {
        assert clazz != null;
        assert observer != null;

        if (observers == null) {
            observers = new java.util.LinkedHashMap<>();
        }
        IEventObserver<?>[] observersForClass = observers.get(clazz);
        if (observersForClass == null) {
            observersForClass = new IEventObserver<?>[0];
        }
        IEventObserver<?>[] newObserversForClass = new IEventObserver<?>[observersForClass.length + 1];
        System.arraycopy(observersForClass, 0, newObserversForClass, 0, observersForClass.length);
        newObserversForClass[observersForClass.length] = observer;
        observers.put(clazz, newObserversForClass);
    }

    @Override
    public <T extends IEvent> void removeObserver(Class<T> clazz, IEventObserver<? super T> observer) {
        IEventObserver<?>[] observersForClass = observers.get(clazz);
        if (observersForClass == null) {
            return;
        }
        int index = -1;
        for (int i = 0; i < observersForClass.length; i++) {
            if (observersForClass[i] == observer || observersForClass[i].equals(observer)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return;
        }
        IEventObserver<?>[] newObserversForClass = new IEventObserver<?>[observersForClass.length - 1];
        System.arraycopy(observersForClass, 0, newObserversForClass, 0, index);
        System.arraycopy(observersForClass, index + 1, newObserversForClass, index, observersForClass.length - index - 1);
        observers.put(clazz, newObserversForClass);
    }

    @Override
    public <T extends IEvent> void notifyObservers(DrawHolder<?> holder, T event) {
        observers.forEach((clazz, observers) -> {
            if (clazz.isInstance(event)) {
                for (IEventObserver observer : observers) {
                    observer.onEvent(holder, event);
                }
            }
        });
    }

}
