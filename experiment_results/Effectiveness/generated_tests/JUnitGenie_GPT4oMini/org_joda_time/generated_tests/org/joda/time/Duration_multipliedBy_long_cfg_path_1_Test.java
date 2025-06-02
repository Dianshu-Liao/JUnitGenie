package org.joda.time;
import org.joda.time.Duration;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Duration_multipliedBy_long_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMultipliedBy() {
        // Arrange
        Duration duration = new Duration(1000L); // 1 second
        long multiplicand = 2L; // Valid long value

        // Act
        Duration result = duration.multipliedBy(multiplicand);

        // Assert
        assertEquals(new Duration(2000L), result); // Expecting 2 seconds
    }

    @Test(timeout = 4000)
    public void testMultipliedByWithOne() {
        // Arrange
        Duration duration = new Duration(1000L); // 1 second
        long multiplicand = 1L; // Edge case

        // Act
        Duration result = duration.multipliedBy(multiplicand);

        // Assert
        assertEquals(duration, result); // Expecting the same duration
    }

    @Test(timeout = 4000)
    public void testMultipliedByWithNegative() {
        // Arrange
        Duration duration = new Duration(1000L); // 1 second
        long multiplicand = -1L; // Valid long value

        // Act
        Duration result = duration.multipliedBy(multiplicand);

        // Assert
        assertEquals(new Duration(-1000L), result); // Expecting -1 second
    }

    @Test(timeout = 4000)
    public void testMultipliedByWithZero() {
        // Arrange
        Duration duration = new Duration(1000L); // 1 second
        long multiplicand = 0L; // Valid long value

        // Act
        Duration result = duration.multipliedBy(multiplicand);

        // Assert
        assertEquals(new Duration(0L), result); // Expecting 0 seconds
    }

}