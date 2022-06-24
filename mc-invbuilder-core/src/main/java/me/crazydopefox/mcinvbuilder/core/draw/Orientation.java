package me.crazydopefox.mcinvbuilder.core.draw;

public enum Orientation {

    HORIZONTAL,
    VERTICAL;

    public static Orientation getOrientation(String orientation) {
        if (orientation.equalsIgnoreCase("horizontal")) {
            return HORIZONTAL;
        } else if (orientation.equalsIgnoreCase("vertical")) {
            return VERTICAL;
        } else {
            throw new IllegalArgumentException("Invalid orientation: " + orientation);
        }
    }

}
