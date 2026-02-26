package com.kata.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    @Test
    public void should_increment_y_when_moving_north() {
        Position position = new Position(0, 0);
        position.move(Direction.N);
        assertEquals(0, position.getX());
        assertEquals(1, position.getY());
    }

    @Test
    public void should_increment_x_when_moving_east() {
        Position position = new Position(0, 0);
        position.move(Direction.E);
        assertEquals(1, position.getX());
        assertEquals(0, position.getY());
    }

    @Test
    public void should_decrement_y_when_moving_south() {
        Position position = new Position(0, 0);
        position.move(Direction.S);
        assertEquals(0, position.getX());
        assertEquals(-1, position.getY());
    }

    @Test
    public void should_decrement_x_when_moving_west() {
        Position position = new Position(0, 0);
        position.move(Direction.W);
        assertEquals(-1, position.getX());
        assertEquals(0, position.getY());
    }
}
