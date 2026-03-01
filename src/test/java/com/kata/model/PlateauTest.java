package com.kata.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlateauTest {
    @Test
    public void should_return_true_if_position_is_inside() {
        Plateau plateau = new Plateau(5, 5);
        Position insidePosition = new Position(3, 3);
        assertTrue(plateau.isWithinBounds(insidePosition));
    }

    @Test
    public void should_return_false_if_position_is_outside() {
        Plateau plateau = new Plateau(5, 5);
        Position outsidePosition = new Position(6, 6);
        assertFalse(plateau.isWithinBounds(outsidePosition));
    }

    @Test
    public void should_return_false_if_x_is_negative() {
        Plateau plateau = new Plateau(5, 5);
        Position position = new Position(-1, 3);
        assertFalse(plateau.isWithinBounds(position));
    }

    @Test
    public void should_return_false_if_y_is_negative() {
        Plateau plateau = new Plateau(5, 5);
        Position position = new Position(3, -1);
        assertFalse(plateau.isWithinBounds(position));
    }

    @Test
    public void should_return_false_if_y_exceeds_height() {
        Plateau plateau = new Plateau(5, 5);
        Position position = new Position(3, 6);
        assertFalse(plateau.isWithinBounds(position));
    }

    @Test
    public void should_return_false_if_x_exceeds_width() {
        Plateau plateau = new Plateau(5, 5);
        Position position = new Position(6, 3);
        assertFalse(plateau.isWithinBounds(position));
    }
}
