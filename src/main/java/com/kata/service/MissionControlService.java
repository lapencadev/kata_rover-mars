package com.kata.service;

import com.kata.model.Direction;
import com.kata.model.Plateau;
import com.kata.model.Position;
import com.kata.model.Rover;

public class MissionControlService {
    public String executeMission(String inputNASA) {
        String[] lines = inputNASA.split("\\r?\\n");
        if (lines.length == 0) return "";

        String[] plateauParts = lines[0].trim().split(" ");
        int width = Integer.parseInt(plateauParts[0]);
        int height = Integer.parseInt(plateauParts[1]);
        Plateau plateau = new Plateau(width, height);

        StringBuilder output = new StringBuilder();

        for (int i = 1; i < lines.length; i += 2) {
            String startPosition = lines[i].trim();
            String commands = lines[i + 1].trim();

            String roverResult = processRover(plateau, startPosition, commands);
            output.append(roverResult);
            if (i + 2 < lines.length) {
                output.append("\n");
            }

        }
        return output.toString();
    }

    private String processRover(Plateau plateau, String startPosition, String commands) {
        String[] parts = startPosition.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        Direction direction = Direction.valueOf(parts[2]);

        Rover rover = new Rover(new Position(x, y), direction);

        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L' -> rover.turnLeft();
                case 'R' -> rover.turnRight();
                case 'M' -> {
                    rover.move();
                    if (!plateau.isWithinBounds(rover.getPosition())) {
                        throw new IllegalStateException("Rover moved out of bounds");
                    }
                }
            }
        }
        return rover.getPosition().getX() + " " + rover.getPosition().getY() + " " + rover.getDirection();
    }
}
