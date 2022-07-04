package me.crazydopefox.mcinvbuilder.core.draw.components;

import lombok.Builder;
import me.crazydopefox.mcinvbuilder.core.draw.*;
import me.crazydopefox.mcinvbuilder.core.utils.IterateUtils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.BiFunction;
import java.util.function.Supplier;

@Builder
public class BorderWidget<T> extends Panel<T> {

    private final int borderWidth;
    private final int borderHeight;
    private final BiFunction<Integer, Integer, Iterable<Point>> borderShapeFunction;
    private final Iterable<Supplier<IWidget<T>>> creators;

    private BorderWidget(Iterable<Supplier<IWidget<T>>> creators, int borderWidth, int borderHeight, BiFunction<Integer, Integer, Iterable<Point>> borderShapeFunction) {
        super(new LinkedList<>());
        this.borderWidth = borderWidth;
        this.borderHeight = borderHeight;
        this.borderShapeFunction = borderShapeFunction;
        this.creators = creators;
    }

    public void redraw() {
        if (drawPanel == null)
            return;

        for (IWidget<T> child : getChildren()) {
            try {
                child.detach();
            } catch (IllegalStateException ignored) {}
        }
        getChildren().clear();


        int height = getHeight();
        int width = getWidth();

        Iterator<Point> borderShape = borderShapeFunction.apply(height, width).iterator();
        Iterator<Supplier<IWidget<T>>> childIterator = IterateUtils.infinity(creators);

        while (borderShape.hasNext()) {
            Point point = borderShape.next();
            Supplier<IWidget<T>> childCreator = childIterator.next();
            PointerDrawPanel<T> panel = new PointerDrawPanel<>(drawPanel);
            panel.setStartX(point.getX());
            panel.setStartY(point.getY());
            panel.setEndX(point.getX());
            panel.setEndY(point.getY());
            IWidget<T> child = childCreator.get();
            addChild(child);
            child.attach(holder, panel);
        }
    }

    @Override
    public int getHeight() {
        return borderHeight == 0 && drawPanel != null ? drawPanel.getHeight() : borderHeight;
    }

    @Override
    public int getWidth() {
        return borderWidth == 0 && drawPanel != null ? drawPanel.getWidth() : borderWidth;
    }

    @Override
    public void attach(DrawHolder<T> holder, IDrawPanel<T> panel) {
        super.attach(holder, panel);
        redraw();
    }

    @Override
    protected void attachChildren() {

    }

    @Override
    protected void detachChildren() {

    }

}
