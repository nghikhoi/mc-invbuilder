package me.crazydopefox.mcinvbuilder.core.draw;

import me.crazydopefox.mcinvbuilder.core.draw.components.StackPanel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestDraw {

    static class TestDrawPanel extends IDrawPanel<Integer> {

        private final int height, width;
        private final int[][] data;

        TestDrawPanel(int height, int width) {
            this.height = height;
            this.width = width;
            this.data = new int[height][width];
        }

        @Override
        public int getHeight() {
            return height;
        }

        @Override
        public int getWidth() {
            return width;
        }

        public int[][] getData() {
            return data;
        }

        @Override
        public DrawSession<Integer> startDrawSession() {
            return new DrawSession<>(this) {
                @Override
                protected <W extends WidgetObject<Integer>> void doDraw(int x, int y, W value) {
                    data[x][y] = value.getValue();
                }

                @Override
                protected void doClean() {
                    for (int y = 0; y < height; y++) {
                        for (int x = 0; x < width; x++) {
                            data[x][y] = 0;
                        }
                    }
                }

                @Override
                protected void doClean(int x, int y) {
                    data[x][y] = 0;
                }
            };
        }

    }

    static class TestDrawFactory extends AbstractDrawFactory<Integer> {

        @Override
        public TestDrawPanel createDrawPanel(int height, int width) {
            return new TestDrawPanel(height, width);
        }

    }

    @Test
    void testDrawableObject() {
        TestDrawFactory factory = new TestDrawFactory();

        WidgetObject<Integer> object = new WidgetObject<>();
        object.setValue(1);
        DrawHolder<Integer> holder = factory.createDrawHolder(object, 1, 1);
        holder.build();
        assertArrayEquals(new int[][] {{1}}, ((TestDrawPanel) holder.getDrawPanel()).getData());
    }

    @Test
    void testStackPanel() {
        TestDrawFactory factory = new TestDrawFactory();

        WidgetObject<Integer> object = new WidgetObject<>();
        object.setValue(1);
        StackPanel<Integer> panel1 = new StackPanel<>(Orientation.HORIZONTAL);
        panel1.addChild(object);
        panel1.addChild(object);

        WidgetObject<Integer> object2 = new WidgetObject<>();
        object2.setValue(2);
        StackPanel<Integer> panel2 = new StackPanel<>(Orientation.VERTICAL);

        StackPanel<Integer> panel3 = new StackPanel<>(Orientation.HORIZONTAL);
        panel3.addChild(object2);

        panel2.addChild(panel3);
        panel2.addChild(object2);

        StackPanel<Integer> panel = new StackPanel<>(Orientation.VERTICAL);

        DrawHolder<Integer> holder = factory.createDrawHolder(panel, 3, 2);
        holder.build();

        panel.addChild(panel1);
        panel.addChild(panel2);
        assertArrayEquals(new int[][] {{1, 1}, {2, 0}, {2, 0}}, ((TestDrawPanel) holder.getDrawPanel()).getData());

        panel3.addChild(object2);
        assertArrayEquals(new int[][] {{1, 1}, {2, 2}, {2, 0}}, ((TestDrawPanel) holder.getDrawPanel()).getData());
    }

}
