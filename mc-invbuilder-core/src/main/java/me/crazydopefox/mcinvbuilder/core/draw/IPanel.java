package me.crazydopefox.mcinvbuilder.core.draw;

import java.util.List;

public interface IPanel<T> extends IDrawable<T> {

    void addChild(IDrawable<T> child);

    List<IDrawable<T>> getChildren();

}
