package me.crazydopefox.mcinvbuilder.core.draw;

public abstract class IDrawPanel<T> {

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract DrawSession<T> startDrawSession();

}
