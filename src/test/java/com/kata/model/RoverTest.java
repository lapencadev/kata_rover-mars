package com.kata.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {
    @Test
    public void rover_turns_left() {
        Position initialPosition = new Position(1, 2);
        Rover rover = new Rover(initialPosition, Direction.N);
        Rover rover2 = new Rover(initialPosition, Direction.S);
        Rover rover3 = new Rover(initialPosition, Direction.W);
        Rover rover4 = new Rover(initialPosition, Direction.E);

        rover.turnLeft();
        rover2.turnLeft();
        rover3.turnLeft();
        rover4.turnLeft();

        assertEquals(Direction.W, rover.getDirection());
        assertEquals(Direction.E, rover2.getDirection());
        assertEquals(Direction.S, rover3.getDirection());
        assertEquals(Direction.N, rover4.getDirection());
    }

    @Test
    public void rover_turns_right() {
        Position initialPosition = new Position(1, 2);
        Rover rover = new Rover(initialPosition, Direction.N);
        Rover rover2 = new Rover(initialPosition, Direction.S);
        Rover rover3 = new Rover(initialPosition, Direction.W);
        Rover rover4 = new Rover(initialPosition, Direction.E);

        rover.turnRight();
        rover2.turnRight();
        rover3.turnRight();
        rover4.turnRight();

        assertEquals(Direction.E, rover.getDirection());
        assertEquals(Direction.W, rover2.getDirection());
        assertEquals(Direction.N, rover3.getDirection());
        assertEquals(Direction.S, rover4.getDirection());
    }

    @Test
    public void rover_moves_forward() {
        Position initialPosition = new Position(1, 2);
        Rover rover = new Rover(initialPosition, Direction.N);

        rover.move();

        assertEquals(1, rover.getPosition().getX());
        assertEquals(3, rover.getPosition().getY());
    }
}
