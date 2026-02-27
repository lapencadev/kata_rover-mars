# Rover on Mars Kata by Raquel!

This is my implementation of the Mars Rover Kata. I focused on creating a clean, object-oriented solution that is easy to test and maintain.

## 🛠️ How I built it (my process)

1.  **Project setup**: I used **Maven** to manage the project and added **JUnit 5** for testing.
2.  **Logic separation**: I split the code into two main parts:
    *   **Model**: Where the "rules" of Mars live (Rover, Position, Direction, Plateau).
    *   **Services**: Orchestrates the mission, parsing NASA strings into domain objects.
3.  **TDD (Test-Driven Development)**: I wrote tests before the actual logic to make sure the Rover turns and moves correctly without bugs, following a red-green-refactor cycle.
4.  **Smart enums**: I used a Java `Enum` for Directions (N, E, S, W) so the logic for turning left or right stays inside the direction itself.

## 📂 Project Structure
```text
src/main/java/com/kata
├── Main.java               # Application entry point
├── model/                  # Domain objects (Rover, Position, etc.)
├── service/                # Business logic (MissionControlService)
└── exception/              # Custom exceptions (OutOfBounds, InvalidInput)

src/test/java/com/kata      # Mirror structure for Unit & Integration tests
```

## 🧠 Service Logic

The service takes the mission input, validates it, builds the models ensuring Plateau boundaries, and processes the rover commands step by step. It returns the rover's final state. Custom exceptions are used for invalid mission input and out-of-bounds errors.

## 🚀 How to run the tests
You can run all the tests using Maven:
`mvn test`

## 🏃🏻‍♀️ Run Application
You can run the Main class. It will wait for your input via console:
1. Enter the plateau size (e.g., 5 5).
2. Enter rover position (e.g., 1 2 N).
3. Enter commands (e.g., LMLMLMLMM).
4. Press Enter twice to see the result.

## 🐳 Run with Docker (Recommended)
You don't need Java 21 installed. Just run:
> **Note**: Ensure [Docker Desktop](https://www.docker.com) is running before executing these commands.

1. **Build the image**:
   ```bash
   docker build -t mars-rover-kata .
    ```
2. **Run the container**:
    ```bash
    docker run -it --rm mars-rover-kata
    ```
