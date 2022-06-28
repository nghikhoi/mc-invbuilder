package me.crazydopefox.mcinvbuilder.core.draw;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class PointerDrawPanel<T extends IDrawable<?>> extends IDrawPanel<T> {

    private final IDrawPanel<T> panel;

    @Setter @Getter
    private int startX, endX;
    @Setter @Getter
    private int startY, endY;

    public PointerDrawPanel(IDrawPanel<T> panel) {
        this.panel = panel;
        this.startX = 0;
        this.startY = 0;
        this.endX = panel.getWidth();
        this.endY = panel.getHeight();
    }

    @Override
    public int getHeight() {
        return endY - startY;
    }

    @Override
    public int getWidth() {
        return endX - startX;
    }

    @Override
    public DrawSession<T> startDrawSession() {
        return new PointerDrawSession<>(this);
    }

    static class PointerDrawSession<T extends IDrawable<?>> extends DrawSession<T> {
        private final PointerDrawPanel<T> drawPanel;
        private final List<Consumer<DrawSession<T>>> actions = new LinkedList<>();

        public PointerDrawSession(PointerDrawPanel<T> drawPanel) {
            super(drawPanel);
            this.drawPanel = drawPanel;
        }

        @Override
        public DrawSession<T> draw(int x, int y, T value) {
            actions.add(session -> session.draw(x, y, value));
            return this;
        }

        @Override
        public void apply() {
            DrawSession<T> session = drawPanel.panel.startDrawSession();
            actions.forEach(action -> action.accept(session));
            session.apply();
        }

    }

}
