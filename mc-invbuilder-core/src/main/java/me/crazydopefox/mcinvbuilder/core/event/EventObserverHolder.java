package me.crazydopefox.mcinvbuilder.core.event;

import java.util.LinkedList;
import java.util.List;

public class EventObserverHolder {

    private final IEventSource source;
    private final List<IEventObserver<?>> observerSet = new LinkedList<>();

    public EventObserverHolder(IEventSource source) {
        this.source = source;
    }

    public void addObserver(Class<? extends Event> clazz, IEventObserver<? super Event> observer) {
        source.addObserver(clazz, observer);
        observerSet.add(observer);
    }

    public void shutdown() {
        observerSet.forEach(IEventObserver::shutdown);
    }

}
