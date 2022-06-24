package me.crazydopefox.mcinvbuilder.core.draw;

public interface IDrawable<T> {

    DrawResult draw(DrawContext context);

    void attach(IDrawPanel<T> panel);

    void detach();

    int getHeight();

    int getWidth();

    void onClick(int x, int y, int button);

}
