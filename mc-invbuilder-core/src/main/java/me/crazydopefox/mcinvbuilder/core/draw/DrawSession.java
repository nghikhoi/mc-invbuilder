package me.crazydopefox.mcinvbuilder.core.draw;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public abstract class DrawSession<T> {

    @Getter protected IDrawPanel<T> drawPanel;
    private final List<Runnable> actions = new LinkedList<>();

    public DrawSession(IDrawPanel<T> drawPanel) {
        this.drawPanel = drawPanel;
    }

    public <W extends WidgetObject<T>> DrawSession<T> draw(int x, int y, W drawable) {
        actions.add(() -> doDraw(x, y, drawable));
        return this;
    }

    public DrawSession<T> clean() {
        actions.add(this::doClean);
        return this;
    }

    public DrawSession<T> clean(int x, int y) {
        actions.add(() -> doClean(x, y));
        return this;
    }

    protected abstract <W extends WidgetObject<T>> void doDraw(int x, int y, W value);

    protected abstract void doClean();

    protected abstract void doClean(int x, int y);

    public void apply() {
        actions.forEach(Runnable::run);
    }

}
