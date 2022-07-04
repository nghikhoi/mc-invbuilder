package me.crazydopefox.mcinvbuilder.core.draw;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class PointerDrawPanel<T> extends IDrawPanel<T> {

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
        return endY - startY + 1;
    }

    @Override
    public int getWidth() {
        return endX - startX + 1;
    }

    @Override
    public DrawSession<T> startDrawSession() {
        return new PointerDrawSession<>(this);
    }

    static class PointerDrawSession<T> extends DrawSession<T> {

        private final PointerDrawPanel<T> drawPanel;
        private final List<Consumer<DrawSession<T>>> actions = new LinkedList<>();

        public PointerDrawSession(PointerDrawPanel<T> drawPanel) {
            super(drawPanel);
            this.drawPanel = drawPanel;
        }

        public <W extends WidgetObject<T>> void doDraw(int x, int y, W value) {
            actions.add(session -> session.draw(x + drawPanel.getStartX(), y + drawPanel.getStartY(), value));
        }

        public void doClean() {
            actions.add(DrawSession::clean);
        }

        public void doClean(int x, int y) {
            actions.add(session -> session.clean(x, y));
        }

        @Override
        public void apply() {
            super.apply();
            DrawSession<T> session = drawPanel.panel.startDrawSession();
            actions.forEach(action -> action.accept(session));
            session.apply();
        }

    }

}
