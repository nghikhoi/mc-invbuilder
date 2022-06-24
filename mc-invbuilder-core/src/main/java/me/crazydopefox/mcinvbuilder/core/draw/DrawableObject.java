package me.crazydopefox.mcinvbuilder.core.draw;

import lombok.Getter;
import lombok.Setter;

public class DrawableObject<T> implements IDrawable<T> {

    @Getter @Setter private T value;

    @Override
    public DrawResult draw(DrawContext context, IDrawPanel<T> panel) {
        DrawResult result = new DrawResult(1, 1);
        panel.draw(0, 0, value);
        return result;
    }

    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public int getWidth() {
        return 1;
    }

    @Override
    public void onClick(int x, int y, int button) {

    }

}
