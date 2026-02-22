package com.kata.model;

public class Plateau {
    private final int width;
    private final int height;

    public Plateau(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isWithinBounds(Position position) {
        return position.getX() >= 0 && position.getX() <= width &&
               position.getY() >= 0 && position.getY() <= height;
    }
}
