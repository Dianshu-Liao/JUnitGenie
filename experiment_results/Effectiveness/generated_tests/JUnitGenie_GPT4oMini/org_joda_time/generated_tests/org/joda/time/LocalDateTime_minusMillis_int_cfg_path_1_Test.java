package org.joda.time;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalDateTime_minusMillis_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMinusMillis() {
        // Arrange
        LocalDateTime dateTime = new LocalDateTime(2023, 10, 1, 12, 0, 0); // Example date
        int millisToSubtract = 1000; // Subtract 1 second

        // Act
        LocalDateTime result = dateTime.minusMillis(millisToSubtract);

        // Assert
        LocalDateTime expected = new LocalDateTime(2023, 10, 1, 11, 59, 59); // Expected result after subtraction
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testMinusMillisWithZero() {
        // Arrange
        LocalDateTime dateTime = new LocalDateTime(2023, 10, 1, 12, 0, 0); // Example date
        int millisToSubtract = 0; // No subtraction

        // Act
        LocalDateTime result = dateTime.minusMillis(millisToSubtract);

        // Assert
        assertEquals(dateTime, result); // Should return the same instance
    }

    @Test(timeout = 4000)
    public void testMinusMillisWithNegativeValue() {
        // Arrange
        LocalDateTime dateTime = new LocalDateTime(2023, 10, 1, 12, 0, 0); // Example date
        int millisToSubtract = -1000; // Subtracting a negative value means adding

        // Act
        LocalDateTime result = dateTime.minusMillis(millisToSubtract);

        // Assert
        LocalDateTime expected = new LocalDateTime(2023, 10, 1, 12, 0, 1); // Expected result after addition
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testMinusMillisWithLargeValue() {
        // Arrange
        LocalDateTime dateTime = new LocalDateTime(2023, 10, 1, 12, 0, 0); // Example date
        int millisToSubtract = 2147483647; // Maximum int value

        // Act
        LocalDateTime result = dateTime.minusMillis(millisToSubtract);

        // Assert
        // The expected result will depend on the implementation of the minusMillis method
        // Here we assume it correctly handles large values
        // You may need to calculate the expected value based on your requirements
    }

}