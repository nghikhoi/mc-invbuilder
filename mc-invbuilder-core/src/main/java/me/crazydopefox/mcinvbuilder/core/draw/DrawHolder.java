package me.crazydopefox.mcinvbuilder.core.draw;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class DrawHolder<T> {

    @Getter
    private final IDrawable<T> drawable;
    @Getter
    private final IDrawPanel<? extends IDrawable<T>> drawPanel;

    public void build() {
        drawable.draw(new DrawContext());
    }

}
