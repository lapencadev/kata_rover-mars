import com.kata.model.Plateau;
import com.kata.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlateauTest {
    @Test
    void should_return_true_if_position_is_inside() {
        Plateau plateau = new Plateau(5, 5);
        Position insidePosition = new Position(3, 3);
        assertTrue(plateau.isWithinBounds(insidePosition));
    }

    @Test
    void should_return_false_if_position_is_outside() {
        Plateau plateau = new Plateau(5, 5);
        Position outsidePosition = new Position(6, 6);
        assertFalse(plateau.isWithinBounds(outsidePosition));
    }
}
