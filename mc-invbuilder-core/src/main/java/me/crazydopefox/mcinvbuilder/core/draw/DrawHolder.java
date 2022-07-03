package me.crazydopefox.mcinvbuilder.core.draw;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class DrawHolder<T> {

    @Getter
    private final IWidget<T> drawable;
    @Getter
    private final IDrawPanel<T> drawPanel;

    public void build() {
        drawable.attach(this, drawPanel);
    }

}
