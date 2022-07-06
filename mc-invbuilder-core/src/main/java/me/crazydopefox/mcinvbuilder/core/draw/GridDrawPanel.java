package me.crazydopefox.mcinvbuilder.core.draw;

import lombok.Getter;

public class GridDrawPanel<T> extends IDrawPanel<T> {

    @Getter private final int height, width;
    private final WidgetObject<T>[][] datas;

    public GridDrawPanel(Class<T> clazz, int height, int width) {
        this.height = height;
        this.width = width;
        this.datas = new WidgetObject<>[height][width];
    }

    public WidgetObject<T> getWidget(int x, int y) {
        return datas[x][y];
    }

    @Override
    public DrawSession<T> startDrawSession() {
        return new DrawSession<>(this) {
            @Override
            protected <W extends WidgetObject<T>> void doDraw(int x, int y, W value) {
                datas[x][y] = value;
            }

            @Override
            protected void doClean() {
                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        datas[x][y] = null;
                    }
                }
            }

            @Override
            protected void doClean(int x, int y) {
                datas[x][y] = null;
            }
        };
    }

}
