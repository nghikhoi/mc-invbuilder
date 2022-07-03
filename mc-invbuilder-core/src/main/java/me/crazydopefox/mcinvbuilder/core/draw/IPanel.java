package me.crazydopefox.mcinvbuilder.core.draw;

import java.util.List;

public interface IPanel<T> extends IWidget<T> {

    void addChild(IWidget<T> child);

    List<IWidget<T>> getChildren();

}
