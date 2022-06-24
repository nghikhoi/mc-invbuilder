package me.crazydopefox.mcinvbuilder.core.draw;

public abstract class Drawable<T> implements IDrawable<T> {

    protected IDrawPanel<T> drawPanel;

    @Override
    public void attach(IDrawPanel<T> panel) {
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
