//This class demonstrates a simple sum test and an even number test function.

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BasicUnitTest {

    @Test
    void testSum() {
        int a = 2;
        int b = 3;
        int result = a + b;
        assertEquals(5, result, "Sum should be 5");
    }

    @Test
    void testIsEven() {
        int value = 4;
        assertTrue(isEven(value), "Value should be even");
    }

    // Simple helper method to demonstrate unit testing
    boolean isEven(int number) {
        return number % 2 == 0;
    }
}
