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

    @Test
    public void should_throw_exception_when_plateau_format_is_invalid() {
        MissionControlService service = new MissionControlService();
        String inputNASA = "5\n1 2 N\nLMLMLMLMM";
        assertThrows(InvalidMissionInputException.class, () -> service.executeMission(inputNASA));
    }

    @Test
    public void should_throw_exception_when_rover_position_is_invalid() {
        MissionControlService service = new MissionControlService();
        String inputNASA = "5 5\n1 N\nLMLMLMLMM";
        assertThrows(InvalidMissionInputException.class, () -> service.executeMission(inputNASA));
    }

    @Test
    public void should_throw_exception_when_missing_rover_commands() {
        MissionControlService service = new MissionControlService();
        String inputNASA = "5 5\n1 2 N";
        assertThrows(InvalidMissionInputException.class, () -> service.executeMission(inputNASA));
    }

    @Test
    public void should_throw_exception_when_input_is_null() {
        MissionControlService service = new MissionControlService();
        assertThrows(InvalidMissionInputException.class, () -> service.executeMission(null));
    }

    @Test
    public void should_throw_exception_when_direction_is_invalid() {
        MissionControlService service = new MissionControlService();
        String inputNASA = "5 5\n1 2 X\nM";
        assertThrows(InvalidMissionInputException.class, () -> service.executeMission(inputNASA));
    }

    @Test
    public void should_throw_exception_when_starting_position_is_out_of_bounds() {
        MissionControlService service = new MissionControlService();
        String inputNASA = "1 1\n2 2 N\nM";
        assertThrows(PositionOutOfBoundsException.class, () -> service.executeMission(inputNASA));
    }

    @Test
    public void should_throw_exception_when_plateau_line_is_blank() {
        MissionControlService service = new MissionControlService();
        String inputNASA = " \n1 2 N\nM";
        assertThrows(InvalidMissionInputException.class, () -> service.executeMission(inputNASA));
    }

    @Test
    public void should_throw_exception_when_plateau_has_non_numeric_dimensions() {
        MissionControlService service = new MissionControlService();
        String inputNASA = "5 X\n1 2 N\nM";
        assertThrows(InvalidMissionInputException.class, () -> service.executeMission(inputNASA));
    }

    @Test
    public void should_process_commands_with_spaces_as_in_kata_example() {
        MissionControlService service = new MissionControlService();
        String inputNASA =
                """
                        5 5
                        1 2 N
                        L M L M L M L M M
                        3 3 E
                        M M R M M R M R R M""";

        String expected = """
                        1 3 N
                        5 1 E""";

        assertEquals(expected, service.executeMission(inputNASA));
    }

    @Test
    public void should_throw_exception_when_commands_are_only_whitespace() {
        MissionControlService service = new MissionControlService();
        String inputNASA = "5 5\n1 2 N\n   \n";
        assertThrows(InvalidMissionInputException.class, () -> service.executeMission(inputNASA));
    }
}
