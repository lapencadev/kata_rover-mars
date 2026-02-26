package com.kata.service;

import com.kata.exception.InvalidCommandException;
import com.kata.exception.InvalidMissionInputException;
import com.kata.exception.PositionOutOfBoundsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MissionControlServiceTest {
    @Test
    public void should_process_complete_mission_for_single_rover() {
        MissionControlService service = new MissionControlService();

        String inputNASA =
                """
                        5 5
                        1 2 N
                        LMLMLMLMM""";

        String result = service.executeMission(inputNASA);
        assertEquals("1 3 N", result);
    }

    @Test
    public void should_process_complete_mission_for_multiple_rovers() {
        MissionControlService service = new MissionControlService();
        String inputNASA =
                """
                        5 5
                        1 2 N
                        LMLMLMLMM
                        3 3 E
                        MMRMMRMRRM""";

        String result = service.executeMission(inputNASA);
        String expectedOutput =
                """
                        1 3 N
                        5 1 E""";
        assertEquals(expectedOutput, result);

    }

    @Test
    public void should_throw_exception_when_input_is_empty() {
        MissionControlService service = new MissionControlService();
        assertThrows(InvalidMissionInputException.class, () -> service.executeMission(""));
    }

    @Test
    public void should_throw_exception_when_rover_moves_out_of_bounds() {
        MissionControlService service = new MissionControlService();
        String inputNASA =
                """
                        5 5
                        0 0 S
                        M""";
        assertThrows(PositionOutOfBoundsException.class, () -> service.executeMission(inputNASA));
    }

    @Test
    public void should_throw_exception_when_command_is_unknown() {
        MissionControlService service = new MissionControlService();
        String inputNASA =
                """
                        5 5
                        1 2 N
                        LMLMLMLMX""";
        assertThrows(InvalidCommandException.class, () -> service.executeMission(inputNASA));
    }
}
