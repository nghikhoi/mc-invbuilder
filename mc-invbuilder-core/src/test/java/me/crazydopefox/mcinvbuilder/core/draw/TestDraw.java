package me.crazydopefox.mcinvbuilder.core.draw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestDraw {

    static class TestDrawPanel implements IDrawPanel<Integer> {

        private final int height, width;
        private final int[][] data;

        public int[][] getData() {
            return data;
        }

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

        @Override
        public void draw(int x, int y, Integer c) {
            data[x][y] = c;
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

        DrawableObject<Integer> object = new DrawableObject<>();
        object.setValue(1);
        DrawHolder<Integer> holder = factory.createDrawHolder(object, 1, 1);
        holder.build();
        assertArrayEquals(new int[][] {{1}}, ((TestDrawPanel) holder.getDrawPanel()).getData());
    }

    @Test
    void testStackPanel() {
        TestDrawFactory factory = new TestDrawFactory();

        DrawableObject<Integer> object = new DrawableObject<>();
        object.setValue(1);
        StackPanel<Integer> panel1 = new StackPanel<>(Orientation.HORIZONTAL);
        panel1.addChild(object);
        panel1.addChild(object);

        DrawableObject<Integer> object2 = new DrawableObject<>();
        object2.setValue(2);
        StackPanel<Integer> panel2 = new StackPanel<>(Orientation.VERTICAL);
        panel2.addChild(object2);
        panel2.addChild(object2);

        StackPanel<Integer> panel = new StackPanel<>(Orientation.VERTICAL);
        panel.addChild(panel1);
        panel.addChild(panel2);

        DrawHolder<Integer> holder = factory.createDrawHolder(panel, 3, 2);
        holder.build();
        assertArrayEquals(new int[][] {{1, 1}, {2, 0}, {2, 0}}, ((TestDrawPanel) holder.getDrawPanel()).getData());
    }

}
