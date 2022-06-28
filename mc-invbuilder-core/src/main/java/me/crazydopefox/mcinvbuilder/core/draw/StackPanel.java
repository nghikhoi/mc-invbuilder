package me.crazydopefox.mcinvbuilder.core.draw;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public class StackPanel<T> extends Panel<T> {

    @Getter
    private final Orientation orientation;

    public StackPanel() {
        this(Orientation.VERTICAL);
    }

    @Override
    protected void attachChildren() {

    }

    @Override
    protected void detachChildren() {

    }

    public StackPanel(Orientation orientation) {
        super(new LinkedList<>());
        this.orientation = orientation;
    }

    @Override
    public void addChild(IDrawable<T> child) {
        super.addChild(child);
    }

    @Override
    public DrawResult draw(DrawContext context) {
        int maxHeight = 0;
        int maxWidth = 0;

        int startX = 0;
        int startY = 0;

        PointerDrawPanel<?> pointerPanel = new PointerDrawPanel<>(drawPanel);
        for (int i = 0; i < getChildren().size(); i++) {
            pointerPanel.setStartX(startX);
            pointerPanel.setStartY(startY);

            DrawResult drawResult = getChildren().get(i).draw(context);
            if (orientation == Orientation.VERTICAL) {
                startX += drawResult.getActualHeight();
                maxWidth = Math.max(maxWidth, drawResult.getActualWidth());
                maxHeight += drawResult.getActualHeight();
            } else {
                startY += drawResult.getActualWidth();
                maxWidth += drawResult.getActualWidth();
                maxHeight = Math.max(maxHeight, drawResult.getActualHeight());
            }
        }

        return new DrawResult(maxHeight, maxWidth);
    }

    @Override
    public int getHeight() {
        return orientation == Orientation.VERTICAL ? getChildren().stream().mapToInt(IDrawable::getHeight).sum()
                : getChildren().stream().mapToInt(IDrawable::getHeight).max().orElse(0);
    }

    @Override
    public int getWidth() {
        return orientation == Orientation.HORIZONTAL ? getChildren().stream().mapToInt(IDrawable::getWidth).sum()
                : getChildren().stream().mapToInt(IDrawable::getWidth).max().orElse(0);
    }

    @Override
    public void onClick(int x, int y, int button) {

    }

}
