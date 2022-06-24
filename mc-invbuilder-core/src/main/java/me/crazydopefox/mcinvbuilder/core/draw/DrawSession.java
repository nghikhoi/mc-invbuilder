package me.crazydopefox.mcinvbuilder.core.draw;

import lombok.Getter;

public abstract class DrawSession<T> {

    @Getter protected IDrawPanel<T> drawPanel;

    public DrawSession(IDrawPanel<T> drawPanel) {
        this.drawPanel = drawPanel;
    }

    public abstract DrawSession<T> draw(int x, int y, T value);

    public abstract void apply();

}
