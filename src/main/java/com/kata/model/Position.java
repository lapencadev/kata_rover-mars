package com.kata.model;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(Direction direction) {
        switch (direction) {
            case N -> this.y += 1;
            case E -> this.x += 1;
            case S -> this.y -= 1;
            case W -> this.x -= 1;
        }
    }
}
