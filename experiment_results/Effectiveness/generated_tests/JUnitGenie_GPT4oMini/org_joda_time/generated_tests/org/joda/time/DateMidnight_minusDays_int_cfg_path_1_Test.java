package org.joda.time;
import org.joda.time.DateMidnight;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

public class DateMidnight_minusDays_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMinusDays() {
        // Arrange
        DateMidnight dateMidnight = new DateMidnight(); // Current date
        int daysToSubtract = 1; // Valid input for days

        // Act
        DateMidnight result = dateMidnight.minusDays(daysToSubtract);

        // Assert
        long originalMillis = dateMidnight.getMillis();
        long resultMillis = result.getMillis();
        
        // Ensure the result is not equal to the original milliseconds
        assertNotEquals(originalMillis, resultMillis);
    }

    @Test(timeout = 4000)
    public void testMinusDaysWithZero() {
        // Arrange
        DateMidnight dateMidnight = new DateMidnight(); // Current date
        int daysToSubtract = 0; // Edge case input

        // Act
        DateMidnight result = dateMidnight.minusDays(daysToSubtract);

        // Assert
        // Ensure the result is the same as the original
        assertEquals(dateMidnight, result);
    }


}