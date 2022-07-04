package me.crazydopefox.mcinvbuilder.core.draw;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {

    private int x, y;

    public Point add(Point other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }

    public Point sub(Point other) {
        this.x -= other.x;
        this.y -= other.y;
        return this;
    }

    public Point mul(int factor) {
        this.x *= factor;
        this.y *= factor;
        return this;
    }

    public Point div(int factor) {
        this.x /= factor;
        this.y /= factor;
        return this;
    }

    public Point mul(Point other) {
        this.x *= other.x;
        this.y *= other.y;
        return this;
    }

    public Point div(Point other) {
        this.x /= other.x;
        this.y /= other.y;
        return this;
    }

    public Point center() {
        return div(2);
    }

}
