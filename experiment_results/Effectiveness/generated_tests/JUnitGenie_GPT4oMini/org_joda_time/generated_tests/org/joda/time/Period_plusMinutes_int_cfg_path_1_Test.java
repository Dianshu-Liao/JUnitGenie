package org.joda.time;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Period_plusMinutes_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusMinutes() {
        // Arrange
        Period period = new Period(0, 0, 0, 0); // Initializing a Period object
        int minutesToAdd = 5; // This will cover the path where minutes != 0

        // Act
        Period result = period.plusMinutes(minutesToAdd);

        // Assert
        // Assuming the expected result is a Period representing 5 minutes
        Period expected = new Period(new int[]{0, 0, 0, 5}, PeriodType.minutes());
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testPlusMinutesZero() {
        // Arrange
        Period period = new Period(0, 0, 0, 0); // Initializing a Period object
        int minutesToAdd = 0; // This will cover the path where minutes == 0

        // Act
        Period result = period.plusMinutes(minutesToAdd);

        // Assert
        // The result should be the same as the original period
        assertEquals(period, result);
    }

}