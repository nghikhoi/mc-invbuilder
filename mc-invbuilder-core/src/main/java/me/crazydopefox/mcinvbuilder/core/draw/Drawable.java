package me.crazydopefox.mcinvbuilder.core.draw;

import me.crazydopefox.mcinvbuilder.core.event.Event;
import me.crazydopefox.mcinvbuilder.core.event.EventSource;

public abstract class Drawable<T> implements IDrawable<T> {

    protected IDrawPanel<? extends IDrawable<T>> drawPanel;
    protected EventSource eventSource;

    public EventSource getEventSource() {
        return eventSource == null ? eventSource = new EventSource() : eventSource;
    }

    protected void notifyEvent(Event event) {
        if (eventSource != null) {
            eventSource.notifyObservers(event);
        }
    }

    @Override
    public void attach(IDrawPanel<? extends IDrawable<T>> panel) {
        if (drawPanel != null) {
            throw new IllegalStateException("Already attached to a panel");
        }
        drawPanel = panel;
    }

    @Override
    public void detach() {
        if (drawPanel == null) {
            throw new IllegalStateException("Not attached to a panel");
        }
        drawPanel = null;
    }

}
