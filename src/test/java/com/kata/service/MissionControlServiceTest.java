package com.kata.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissionControlServiceTest {
    @Test
    void should_process_complete_mission_for_single_rover() {
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
    void should_process_complete_mission_for_multiple_rovers() {
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

}
