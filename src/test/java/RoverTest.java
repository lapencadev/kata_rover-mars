import com.kata.model.Direction;
import com.kata.model.Position;
import com.kata.model.Rover;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {
    @Test
    public void rover_turns_left() {
        Position initialPosition = new Position(1, 2);
        Rover rover = new Rover(initialPosition, Direction.N);

        rover.turnLeft();

        assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    public void rover_turns_right() {
        Position initialPosition = new Position(1, 2);
        Rover rover = new Rover(initialPosition, Direction.N);

        rover.turnRight();

        assertEquals(Direction.E, rover.getDirection());
    }
}
