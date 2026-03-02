package com.kata.service;

import com.kata.exception.InvalidCommandException;
import com.kata.exception.InvalidMissionInputException;
import com.kata.exception.PositionOutOfBoundsException;
import com.kata.model.Direction;
import com.kata.model.Plateau;
import com.kata.model.Position;
import com.kata.model.Rover;

public class MissionControlService {
    private static final String ERR_MISSING_COMMANDS = "Missing rover commands";
    private static final String ERR_INVALID_POSITION = "Invalid rover starting position";
    private static final String ERR_OUT_OF_BOUNDS = "Rover moved out of bounds";

    public String executeMission(String inputNASA) {
        String[] lines = validateAndSplitInput(inputNASA);
        try {
            Plateau plateau = parsePlateau(lines[0]);
            return processRovers(plateau, lines);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new InvalidMissionInputException("Invalid plateau format");
        }
    }

    private String[] validateAndSplitInput(String inputNASA) {
        if (inputNASA == null || inputNASA.isBlank()) {
            throw new InvalidMissionInputException("Mission input cannot be empty");
        }
        String[] lines = inputNASA.toUpperCase().split("\\r?\\n");
        if (lines[0].isBlank()) {
            throw new InvalidMissionInputException("Missing plateau configuration");
        }
        return lines;
    }

    private Plateau parsePlateau(String plateauLine) {
        String[] plateauParts = plateauLine.trim().split("\\s+");
        if (plateauParts.length != 2) {
            throw new InvalidMissionInputException("Invalid plateau format");
        }
        int width = Integer.parseInt(plateauParts[0]);
        int height = Integer.parseInt(plateauParts[1]);
        return new Plateau(width, height);
    }

    private String processRovers(Plateau plateau, String[] lines) {
        StringBuilder output = new StringBuilder();
        for (int i = 1; i < lines.length; i += 2) {
            if (i + 1 >= lines.length) {
                throw new InvalidMissionInputException(ERR_MISSING_COMMANDS);
            }
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
        String[] parts = startPosition.split("\\s+");
        if (parts.length != 3) throw new InvalidMissionInputException(ERR_INVALID_POSITION);

        Rover rover;
        try {
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            Direction direction = Direction.valueOf(parts[2]);
            rover = new Rover(new Position(x, y), direction);
        } catch (IllegalArgumentException e) {
            throw new InvalidMissionInputException(ERR_INVALID_POSITION);
        }

        if (!plateau.isWithinBounds(rover.getPosition())) {
            throw new PositionOutOfBoundsException(ERR_OUT_OF_BOUNDS);
        }

        String normalizedCommands = commands.replaceAll("\\s+", "");
        if (normalizedCommands.isEmpty()) {
            throw new InvalidMissionInputException(ERR_MISSING_COMMANDS);
        }

        for (char command : normalizedCommands.toCharArray()) {
            switch (command) {
                case 'L' -> rover.turnLeft();
                case 'R' -> rover.turnRight();
                case 'M' -> {
                    rover.move();
                    if (!plateau.isWithinBounds(rover.getPosition())) {
                        throw new PositionOutOfBoundsException(ERR_OUT_OF_BOUNDS);
                    }
                }
                default -> throw new InvalidCommandException("Unknown command: " + command);
            }
        }
        return rover.getPosition().getX() + " " + rover.getPosition().getY() + " " + rover.getDirection();
    }
}
