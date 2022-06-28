package me.crazydopefox.mcinvbuilder.core.draw;

public abstract class IDrawPanel<T extends IDrawable<?>> {

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract DrawSession<T> startDrawSession();

}
