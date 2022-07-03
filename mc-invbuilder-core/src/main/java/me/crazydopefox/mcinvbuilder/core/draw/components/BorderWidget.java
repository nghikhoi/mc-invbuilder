package me.crazydopefox.mcinvbuilder.core.draw.components;

import me.crazydopefox.mcinvbuilder.core.draw.IWidget;
import me.crazydopefox.mcinvbuilder.core.draw.Panel;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

public class BorderWidget<T> extends Panel<T> {

    private final int borderWidth;
    private final int borderHeight;
    private final BiFunction<Integer, Integer, Iterable<Integer>> borderShapeFunction;
    private final Iterable<IWidget<T>> children;

    public BorderWidget(List<IWidget<T>> children, int borderWidth, int borderHeight, BiFunction<Integer, Integer, Iterable<Integer>> borderShapeFunction) {
        super(new LinkedList<>());
        this.borderWidth = borderWidth;
        this.borderHeight = borderHeight;
        this.borderShapeFunction = borderShapeFunction;
        this.children = children;
    }

    public BorderWidget(List<IWidget<T>> children, BiFunction<Integer, Integer, Iterable<Integer>> borderShapeFunction) {
        this(children, 0, 0, borderShapeFunction);
    }

    public void redraw() {
        if (drawPanel == null)
            return;

        int height = getHeight();
        int width = getWidth();

        int
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
    protected void attachChildren() {

    }

    @Override
    protected void detachChildren() {

    }

}
