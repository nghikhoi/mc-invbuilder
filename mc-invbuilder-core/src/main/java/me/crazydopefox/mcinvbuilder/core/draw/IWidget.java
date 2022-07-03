package me.crazydopefox.mcinvbuilder.core.draw;

import me.crazydopefox.mcinvbuilder.core.event.EventSource;

public interface IWidget<T> {

    void attach(DrawHolder<T> holder, IDrawPanel<T> panel);

    void detach();

    int getHeight();

    int getWidth();

    void onClick(int x, int y, int button);

    EventSource getEventSource();

}
