package me.crazydopefox.mcinvbuilder.core.draw;

import me.crazydopefox.mcinvbuilder.core.draw.event.ClickedEvent;
import me.crazydopefox.mcinvbuilder.core.draw.event.PrepareClickEvent;
import me.crazydopefox.mcinvbuilder.core.event.Event;
import me.crazydopefox.mcinvbuilder.core.event.EventSource;

public abstract class Widget<T> implements IWidget<T> {

    protected IDrawPanel<T> drawPanel;
    protected DrawHolder<T> holder;
    protected EventSource eventSource;

    public EventSource getEventSource() {
        return eventSource == null ? eventSource = new EventSource() : eventSource;
    }

    protected void notifyEvent(Event event) {
        if (eventSource != null) {
            eventSource.notifyObservers(holder, event);
        }
    }

    @Override
    public void attach(DrawHolder<T> holder, IDrawPanel<T> panel) {
        if (drawPanel != null) {
            throw new IllegalStateException("Already attached to a panel");
        }
        drawPanel = panel;
        this.holder = holder;
    }

    @Override
    public void detach() {
        if (drawPanel == null) {
            throw new IllegalStateException("Not attached to a panel");
        }
        eventSource = null;
        drawPanel = null;
        holder = null;
    }

    @Override
    public final void onClick(int x, int y, int button) {
        notifyEvent(new PrepareClickEvent(this));
        doClick(x, y, button);
        notifyEvent(new ClickedEvent(this));
    }

    protected void doClick(int x, int y, int button) {

    }

}
