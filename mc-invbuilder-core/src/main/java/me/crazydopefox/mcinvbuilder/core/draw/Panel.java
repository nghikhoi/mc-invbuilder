package me.crazydopefox.mcinvbuilder.core.draw;

import java.util.List;

public abstract class Panel<T> extends Widget<T> implements IPanel<T> {

    protected List<IWidget<T>> children;

    protected Panel(List<IWidget<T>> children) {
        this.children = children;
    }

    public Panel() {
    }

    protected abstract void attachChildren();

    protected abstract void detachChildren();

    @Override
    public void attach(DrawHolder<T> holder, IDrawPanel<T> panel) {
        super.attach(holder, panel);
        attachChildren();
    }

    @Override
    public void detach() {
        detachChildren();
        super.detach();
    }

    @Override
    public void addChild(IWidget<T> child) {
        children.add(child);
    }

    @Override
    public List<IWidget<T>> getChildren() {
        return children;
    }

}
