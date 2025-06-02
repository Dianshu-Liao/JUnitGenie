package org.joda.time;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_minusYears_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMinusYears() {
        // Arrange
        DateTime dateTime = new DateTime(2023, 10, 1, 0, 0); // Example date
        int yearsToSubtract = 5; // Valid input for years

        // Act
        DateTime result = dateTime.minusYears(yearsToSubtract);

        // Assert
        DateTime expectedDateTime = new DateTime(2018, 10, 1, 0, 0); // Expected result after subtracting 5 years
        assertEquals(expectedDateTime, result);
    }

    @Test(timeout = 4000)
    public void testMinusYearsWithZero() {
        // Arrange
        DateTime dateTime = new DateTime(2023, 10, 1, 0, 0); // Example date
        int yearsToSubtract = 0; // Edge case input

        // Act
        DateTime result = dateTime.minusYears(yearsToSubtract);

        // Assert
        assertEquals(dateTime, result); // Should return the same instance
    }

    @Test(timeout = 4000)
    public void testMinusYearsWithNegativeValue() {
        // Arrange
        DateTime dateTime = new DateTime(2023, 10, 1, 0, 0); // Example date
        int yearsToSubtract = -3; // Valid input for years (negative)

        // Act
        DateTime result = dateTime.minusYears(yearsToSubtract);

        // Assert
        DateTime expectedDateTime = new DateTime(2026, 10, 1, 0, 0); // Expected result after adding 3 years
        assertEquals(expectedDateTime, result);
    }

}