package org.joda.time;
import org.joda.time.Duration;
import org.joda.time.field.FieldUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Duration_withDurationAdded_long_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithDurationAdded() {
        // Arrange
        Duration duration = new Duration(1000L); // Initial duration of 1000 milliseconds
        long durationToAdd = 500L; // Duration to add
        int scalar = 2; // Scalar to multiply with

        // Act
        Duration result = duration.withDurationAdded(durationToAdd, scalar);

        // Assert
        assertEquals(new Duration(2000L), result); // Expecting 1000 + (500 * 2) = 2000 milliseconds
    }

    @Test(timeout = 4000)
    public void testWithDurationAddedZeroDuration() {
        // Arrange
        Duration duration = new Duration(1000L); // Initial duration of 1000 milliseconds
        long durationToAdd = 0L; // Duration to add
        int scalar = 5; // Scalar to multiply with

        // Act
        Duration result = duration.withDurationAdded(durationToAdd, scalar);

        // Assert
        assertEquals(duration, result); // Expecting the same duration since durationToAdd is 0
    }

    @Test(timeout = 4000)
    public void testWithDurationAddedZeroScalar() {
        // Arrange
        Duration duration = new Duration(1000L); // Initial duration of 1000 milliseconds
        long durationToAdd = 500L; // Duration to add
        int scalar = 0; // Scalar to multiply with

        // Act
        Duration result = duration.withDurationAdded(durationToAdd, scalar);

        // Assert
        assertEquals(duration, result); // Expecting the same duration since scalar is 0
    }

    @Test(timeout = 4000)
    public void testWithDurationAddedLargeValues() {
        // Arrange
        Duration duration = new Duration(Long.MAX_VALUE - 1000L); // Initial duration close to Long.MAX_VALUE
        long durationToAdd = 500L; // Duration to add
        int scalar = 1; // Scalar to multiply with

        // Act
        Duration result = duration.withDurationAdded(durationToAdd, scalar);

        // Assert
        assertEquals(new Duration(Long.MAX_VALUE), result); // Expecting the result to be Long.MAX_VALUE
    }

    @Test(timeout = 4000)
    public void testWithDurationAddedNegativeValues() {
        // Arrange
        Duration duration = new Duration(1000L); // Initial duration of 1000 milliseconds
        long durationToAdd = -500L; // Duration to add
        int scalar = 1; // Scalar to multiply with

        // Act
        Duration result = duration.withDurationAdded(durationToAdd, scalar);

        // Assert
        assertEquals(new Duration(500L), result); // Expecting 1000 - 500 = 500 milliseconds
    }

}