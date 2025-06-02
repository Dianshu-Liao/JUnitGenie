package org.joda.time;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalDateTime_minusYears_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMinusYears() {
        // Arrange
        LocalDateTime dateTime = new LocalDateTime(2023, 10, 1, 0, 0); // Example date
        int yearsToSubtract = 1; // Valid input for years

        // Act
        LocalDateTime result = dateTime.minusYears(yearsToSubtract);

        // Assert
        LocalDateTime expected = new LocalDateTime(2022, 10, 1, 0, 0); // Expected result after subtracting 1 year
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testMinusYearsZero() {
        // Arrange
        LocalDateTime dateTime = new LocalDateTime(2023, 10, 1, 0, 0); // Example date
        int yearsToSubtract = 0; // Edge case input

        // Act
        LocalDateTime result = dateTime.minusYears(yearsToSubtract);

        // Assert
        assertEquals(dateTime, result); // Should return the same instance
    }

    @Test(timeout = 4000)
    public void testMinusYearsNegative() {
        // Arrange
        LocalDateTime dateTime = new LocalDateTime(2023, 10, 1, 0, 0); // Example date
        int yearsToSubtract = -1; // Valid input for years (subtracting negative means adding)

        // Act
        LocalDateTime result = dateTime.minusYears(yearsToSubtract);

        // Assert
        LocalDateTime expected = new LocalDateTime(2024, 10, 1, 0, 0); // Expected result after adding 1 year
        assertEquals(expected, result);
    }

}