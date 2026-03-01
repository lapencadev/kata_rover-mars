package com.kata.model;

public class Rover {
    private final Position position;
    private Direction direction;

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void turnLeft(){
        this.direction = this.direction.left();
    }

    public void turnRight(){
        this.direction = this.direction.right();
    }

    public void move() {
        this.position.move(this.direction);
    }

    public Position getPosition() {
        return position;
    }
}
