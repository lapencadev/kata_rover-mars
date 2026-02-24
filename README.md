# Rover on Mars Kata by Raquel!

This is my implementation of the Mars Rover Kata. I focused on creating a clean, object-oriented solution that is easy to test and maintain.

## 🛠️ How I built it (my process)

1.  **Project setup**: I used **Maven** to manage the project and added **JUnit 5** for testing.
2.  **Logic separation**: I split the code into two main parts:
    *   **Models**: Where the "rules" of Mars live (Rover, Position, Direction, Plateau).
    *   **Services**: To handle the input and coordinate the mission.
3.  **TDD (Test-Driven Development)**: I wrote tests before the actual logic to make sure the Rover turns and moves correctly without bugs.
4.  **Smart enums**: I used a Java `Enum` for Directions (N, E, S, W) so the logic for turning left or right stays inside the direction itself.

## 📂 Project Structure
*   `src/java/com/kata/model`: Core domain objects.
*   `src/main/java/com/kata/service`: Orchestration logic to process command strings.
*   `src/test/java/com/kata`: Unit tests for the models and services organized by package.

## 🧠 Service Logic

The service takes the mission input, validates it, builds the models, and processes the rover commands step by step. It returns the rover's final state. Custom exceptions are used for invalid mission input and out-of-bounds errors.

## 🚀 How to run the tests
You can run all the tests using Maven:
`mvn test`