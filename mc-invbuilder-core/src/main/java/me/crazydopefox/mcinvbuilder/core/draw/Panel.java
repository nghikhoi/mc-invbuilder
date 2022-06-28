package me.crazydopefox.mcinvbuilder.core.draw;

import java.util.List;

public abstract class Panel<T> extends Drawable<T> implements IPanel<T> {

    protected List<IDrawable<T>> children;

    protected Panel(List<IDrawable<T>> children) {
        this.children = children;
    }

    public Panel() {
    }

    protected abstract void attachChildren();

    protected abstract void detachChildren();

    @Override
    public void attach(IDrawPanel<? extends IDrawable<T>> panel) {
        super.attach(panel);
        attachChildren();
    }

    @Override
    public void detach() {
        detachChildren();
        super.detach();
    }

    @Override
    public void addChild(IDrawable<T> child) {
        children.add(child);
    }

    @Override
    public List<IDrawable<T>> getChildren() {
        return children;
    }

}
