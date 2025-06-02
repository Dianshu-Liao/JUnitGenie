package org.joda.time;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_plusMinutes_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusMinutes() {
        // Arrange
        DateTime dateTime = new DateTime(2023, 10, 1, 12, 0); // Initial date and time
        int minutesToAdd = 30; // Minutes to add

        // Act
        DateTime result = dateTime.plusMinutes(minutesToAdd);

        // Assert
        DateTime expected = new DateTime(2023, 10, 1, 12, 30); // Expected date and time after adding minutes
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testPlusMinutesWithZero() {
        // Arrange
        DateTime dateTime = new DateTime(2023, 10, 1, 12, 0); // Initial date and time
        int minutesToAdd = 0; // Minutes to add

        // Act
        DateTime result = dateTime.plusMinutes(minutesToAdd);

        // Assert
        assertEquals(dateTime, result); // Should return the same instance
    }

    @Test(timeout = 4000)
    public void testPlusMinutesNegative() {
        // Arrange
        DateTime dateTime = new DateTime(2023, 10, 1, 12, 0); // Initial date and time
        int minutesToAdd = -15; // Minutes to subtract

        // Act
        DateTime result = dateTime.plusMinutes(minutesToAdd);

        // Assert
        DateTime expected = new DateTime(2023, 10, 1, 11, 45); // Expected date and time after subtracting minutes
        assertEquals(expected, result);
    }

}