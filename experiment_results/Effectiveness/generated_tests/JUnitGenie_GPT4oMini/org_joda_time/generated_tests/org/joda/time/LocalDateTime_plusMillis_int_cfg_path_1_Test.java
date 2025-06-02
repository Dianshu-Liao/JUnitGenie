package org.joda.time;
import org.joda.time.LocalDateTime;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalDateTime_plusMillis_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusMillis_NonZeroMillis() {
        // Arrange
        LocalDateTime localDateTime = new LocalDateTime(2023, 10, 1, 12, 0);
        int millisToAdd = 5000; // Adding 5 seconds

        // Act
        LocalDateTime result = localDateTime.plusMillis(millisToAdd);

        // Assert
        LocalDateTime expected = new LocalDateTime(2023, 10, 1, 12, 0, 5); // Expected result after adding 5 seconds
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testPlusMillis_ZeroMillis() {
        // Arrange
        LocalDateTime localDateTime = new LocalDateTime(2023, 10, 1, 12, 0);
        int millisToAdd = 0; // Adding 0 milliseconds

        // Act
        LocalDateTime result = localDateTime.plusMillis(millisToAdd);

        // Assert
        assertEquals(localDateTime, result); // Should return the same instance
    }

    @Test(timeout = 4000)
    public void testPlusMillis_NegativeMillis() {
        // Arrange
        LocalDateTime localDateTime = new LocalDateTime(2023, 10, 1, 12, 0);
        int millisToAdd = -2000; // Subtracting 2 seconds

        // Act
        LocalDateTime result = localDateTime.plusMillis(millisToAdd);

        // Assert
        LocalDateTime expected = new LocalDateTime(2023, 10, 1, 11, 59, 58); // Expected result after subtracting 2 seconds
        assertEquals(expected, result);
    }

}