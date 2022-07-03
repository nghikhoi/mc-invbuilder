package me.crazydopefox.mcinvbuilder.core.draw;

import lombok.Getter;
import lombok.Setter;

public class WidgetObject<T> extends Widget<T> {

    @Getter @Setter private T value;

    @Override
    public void attach(DrawHolder<T> holder, IDrawPanel<T> panel) {
        super.attach(holder, panel);
        panel.startDrawSession().draw(0, 0, this).apply();
    }

    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public int getWidth() {
        return 1;
    }

}
