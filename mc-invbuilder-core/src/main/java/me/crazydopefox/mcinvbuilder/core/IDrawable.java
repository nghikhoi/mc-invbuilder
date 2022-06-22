package me.crazydopefox.mcinvbuilder.core;

public interface IDrawable {

    void draw(IDrawable parent);

    int getHeight();

    int getWidth();

    void onClick(int x, int y, int button);

}
