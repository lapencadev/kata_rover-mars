package com.kata;

import com.kata.service.MissionControlService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MissionControlService service = new MissionControlService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Rover Mission Control!");


        while (true) {
            System.out.println("Enter mission data (type EXIT to quit) and press Enter twice to process:");

            StringBuilder inputBuilder = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.equalsIgnoreCase("EXIT")) {
                    System.out.println("Exiting Mission Control. Goodbye!");
                    return;
                }

                if (line.isBlank()) break;

                inputBuilder.append(line).append("\n");
            }

            String fullInput = inputBuilder.toString().trim();

            try {
                String result = service.executeMission(fullInput);
                System.out.println("Mission Result:");
                System.out.println(result + "\n");
            } catch (Exception e) {
                System.err.println("Error processing mission: " + e.getMessage());
                System.out.println("Format tip: Plateau size (5 5), then Position (1 2 N), then Commands (LMR).");
            }
        }
    }
}
