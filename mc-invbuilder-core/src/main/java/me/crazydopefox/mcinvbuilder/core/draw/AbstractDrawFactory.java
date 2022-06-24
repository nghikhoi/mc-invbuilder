package me.crazydopefox.mcinvbuilder.core.draw;

public abstract class AbstractDrawFactory<T> {

    public DrawHolder<T> createDrawHolder(IDrawable<T> drawable, int height, int width) {
        return new DrawHolder<T>(drawable, createDrawPanel(height, width));
    }

    public abstract IDrawPanel<T> createDrawPanel(int height, int width);

}
