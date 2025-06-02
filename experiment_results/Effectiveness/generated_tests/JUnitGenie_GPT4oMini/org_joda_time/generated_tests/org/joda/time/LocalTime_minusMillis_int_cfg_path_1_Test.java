package org.joda.time;
import org.joda.time.LocalTime;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalTime_minusMillis_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMinusMillis() {
        // Arrange
        LocalTime localTime = new LocalTime(10, 30, 0); // 10:30:00
        int millisToSubtract = 500; // Subtracting 500 milliseconds

        // Act
        LocalTime result = localTime.minusMillis(millisToSubtract);

        // Assert
        LocalTime expected = new LocalTime(10, 29, 59, 500); // Expected result after subtracting 500 milliseconds
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testMinusMillisWithZero() {
        // Arrange
        LocalTime localTime = new LocalTime(10, 30, 0); // 10:30:00
        int millisToSubtract = 0; // Subtracting 0 milliseconds

        // Act
        LocalTime result = localTime.minusMillis(millisToSubtract);

        // Assert
        assertEquals(localTime, result); // Should return the same LocalTime instance
    }

    @Test(timeout = 4000)
    public void testMinusMillisWithNegativeValue() {
        // Arrange
        LocalTime localTime = new LocalTime(10, 30, 0); // 10:30:00
        int millisToSubtract = -500; // Subtracting -500 milliseconds (effectively adding)

        // Act
        LocalTime result = localTime.minusMillis(millisToSubtract);

        // Assert
        LocalTime expected = new LocalTime(10, 30, 0, 500); // Expected result after adding 500 milliseconds
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testMinusMillisWithMinIntegerValue() {
        // Arrange
        LocalTime localTime = new LocalTime(10, 30, 0); // 10:30:00
        int millisToSubtract = Integer.MIN_VALUE; // This should be handled gracefully

        try {
            // Act
            LocalTime result = localTime.minusMillis(millisToSubtract);
            // Assert
            // If no exception is thrown, we can check the result
            assertEquals(localTime, result); // Expected behavior should be defined
        } catch (Exception e) {
            // Handle the exception if thrown
            // Assert that the exception is as expected
        }
    }

}