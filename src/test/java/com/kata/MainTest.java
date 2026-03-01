package com.kata;

import org.junit.jupiter.api.Test;
import java.io.*;

public class MainTest {
    @Test
    void test_main_integration() {
        String input = "5 5\n1 2 N\nLMLMLMLMM\n\nEXIT\n";
        InputStream stdin = System.in;
        PrintStream stdout = System.out;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            Main.main();

            String output = outContent.toString();
            assert output.contains("Mission Result:");
            assert output.contains("1 3 N");
        } finally {
            System.setIn(stdin);
            System.setOut(stdout);
        }
    }

    @Test
    void test_main_handles_invalid_mission_gracefully() {
        String input = "5 5\n1 2 N\n\nEXIT\n";
        InputStream stdin = System.in;
        PrintStream stdout = System.out;
        PrintStream stderr = System.err;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            ByteArrayOutputStream errContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            System.setErr(new PrintStream(errContent));

            Main.main();

            String output = outContent.toString();
            String errors = errContent.toString();
            assert output.contains("Welcome to Rover Mission Control!");
            assert errors.contains("Error processing mission:");
            assert output.contains("Exiting Mission Control. Goodbye!");
        } finally {
            System.setIn(stdin);
            System.setOut(stdout);
            System.setErr(stderr);
        }
    }

    @Test
    void test_main_exits_when_no_input_available() {
        String input = "";
        InputStream stdin = System.in;
        PrintStream stdout = System.out;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            Main.main();

            String output = outContent.toString();
            assert output.contains("Welcome to Rover Mission Control!");
            assert output.contains("Enter mission data");
            assert output.contains("Exiting Mission Control. Goodbye!");
        } finally {
            System.setIn(stdin);
            System.setOut(stdout);
        }
    }
}
