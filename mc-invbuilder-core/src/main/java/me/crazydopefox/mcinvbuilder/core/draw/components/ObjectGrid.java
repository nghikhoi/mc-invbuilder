package me.crazydopefox.mcinvbuilder.core.draw.components;

import lombok.Getter;
import lombok.Setter;
import me.crazydopefox.mcinvbuilder.core.draw.*;

import java.util.HashMap;
import java.util.Map;

public class ObjectGrid<T> extends Panel<T> {

    @Getter @Setter
    private int height, width;

    private final Map<Point, WidgetObject<T>> objects = new HashMap<>();

    public ObjectGrid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void set(int x, int y, WidgetObject<T> object) {
        WidgetObject<T> old = objects.put(new Point(x, y), object);
        if (old != null) {
            old.detach();
        }
        if (drawPanel != null) {
            PointerDrawPanel<T> panel = new PointerDrawPanel<>(drawPanel);
            panel.setStartX(x);
            panel.setStartY(y);
            object.attach(holder, panel);
        }
    }

    @Override
    public void attach(DrawHolder<T> holder, IDrawPanel<T> panel) {
        super.attach(holder, panel);
        objects.forEach((point, object) -> {
            try {
                object.detach();
            } catch (IllegalStateException ignored) {}

            PointerDrawPanel<T> childPanel = new PointerDrawPanel<>(drawPanel);
            childPanel.setStartX(point.getX());
            childPanel.setStartY(point.getY());
            object.attach(holder, childPanel);
        });
    }

    @Override
    protected void attachChildren() {

    }

    @Override
    protected void detachChildren() {

    }
}
