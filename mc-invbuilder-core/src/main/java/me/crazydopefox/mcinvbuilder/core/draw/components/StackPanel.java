package me.crazydopefox.mcinvbuilder.core.draw.components;

import lombok.Getter;
import me.crazydopefox.mcinvbuilder.core.draw.*;
import me.crazydopefox.mcinvbuilder.core.draw.event.SizeChangedEvent;
import me.crazydopefox.mcinvbuilder.core.event.IEventObserver;

import java.util.LinkedList;

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
    public void addChild(IWidget<T> child) {
        int oldHeight = getHeight();
        int oldWidth = getWidth();
        super.addChild(child);
        if (drawPanel != null) {
            int newHeight = getHeight();
            int newWidth = getWidth();
            notifyEvent(new SizeChangedEvent(this, oldHeight, newHeight, oldWidth, newWidth));
        }
        redraw();
    }

    @Override
    public void attach(DrawHolder<T> holder, IDrawPanel<T> panel) {
        super.attach(holder, panel);
        redraw();
    }

    public void redraw() {
        if (drawPanel == null)
            return;
        int maxHeight = 0;
        int maxWidth = 0;

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < getChildren().size(); i++) {
            PointerDrawPanel<T> pointerPanel = new PointerDrawPanel<>(drawPanel);
            pointerPanel.setStartX(startX);
            pointerPanel.setStartY(startY);

            IWidget<T> child = getChildren().get(i);
            try {
                child.detach();
            } catch (IllegalStateException ignored) { }
            child.attach(holder, pointerPanel);
            child.getEventSource().addObserver(SizeChangedEvent.class, (holder, event) -> {
                if (orientation == Orientation.VERTICAL) {
                    if (event.getOldHeight() != event.getNewHeight()) {
                        redraw();
                    }
                } else {
                    if (event.getOldWidth() != event.getNewWidth()) {
                        redraw();
                    }
                }
            });
            if (orientation == Orientation.VERTICAL) {
                startX += child.getHeight();
                maxWidth = Math.max(maxWidth, child.getWidth());
                maxHeight += child.getHeight();
            } else {
                startY += child.getWidth();
                maxWidth += child.getWidth();
                maxHeight = Math.max(maxHeight, child.getHeight());
            }
        }
    }

    @Override
    public int getHeight() {
        return orientation == Orientation.VERTICAL ? getChildren().stream().mapToInt(IWidget::getHeight).sum()
                : getChildren().stream().mapToInt(IWidget::getHeight).max().orElse(0);
    }

    @Override
    public int getWidth() {
        return orientation == Orientation.HORIZONTAL ? getChildren().stream().mapToInt(IWidget::getWidth).sum()
                : getChildren().stream().mapToInt(IWidget::getWidth).max().orElse(0);
    }

}
