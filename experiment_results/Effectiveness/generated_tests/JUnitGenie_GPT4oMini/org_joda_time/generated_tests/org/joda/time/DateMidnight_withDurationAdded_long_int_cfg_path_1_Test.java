package org.joda.time;
import org.joda.time.DateMidnight;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

public class DateMidnight_withDurationAdded_long_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithDurationAdded() {
        // Arrange
        DateMidnight dateMidnight = new DateMidnight(); // Using the default constructor
        long durationToAdd = 1000L; // A valid long value
        int scalar = 1; // A non-zero scalar

        // Act
        DateMidnight result = dateMidnight.withDurationAdded(durationToAdd, scalar);

        // Assert
        // Ensure that the result is not equal to the original instance's millis
        assertNotEquals(dateMidnight.getMillis(), result.getMillis());
    }

    @Test(timeout = 4000)
    public void testWithDurationAddedZeroDuration() {
        // Arrange
        DateMidnight dateMidnight = new DateMidnight(); // Using the default constructor
        long durationToAdd = 0L; // Zero duration
        int scalar = 1; // A non-zero scalar

        // Act
        DateMidnight result = dateMidnight.withDurationAdded(durationToAdd, scalar);

        // Assert
        // Ensure that the result is the same as the original instance
        assertEquals(dateMidnight, result);
    }

    @Test(timeout = 4000)
    public void testWithDurationAddedZeroScalar() {
        // Arrange
        DateMidnight dateMidnight = new DateMidnight(); // Using the default constructor
        long durationToAdd = 1000L; // A valid long value
        int scalar = 0; // Zero scalar

        // Act
        DateMidnight result = dateMidnight.withDurationAdded(durationToAdd, scalar);

        // Assert
        // Ensure that the result is the same as the original instance
        assertEquals(dateMidnight, result);
    }


}