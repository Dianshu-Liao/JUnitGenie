package org.joda.time;
import org.joda.time.Duration;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Duration_standardDays_long_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testStandardDaysWithZero() {
        // Test case for days = 0
        Duration result = Duration.standardDays(0);
        assertEquals(Duration.ZERO, result);
    }

    @Test(timeout = 4000)
    public void testStandardDaysWithPositiveDays() {
        // Test case for positive days
        long days = 1;
        Duration result = Duration.standardDays(days);
        Duration expected = new Duration(24 * 60 * 60 * 1000); // 1 day in milliseconds
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStandardDaysWithNegativeDays() {
        // Test case for negative days
        long days = -1;
        Duration result = Duration.standardDays(days);
        Duration expected = new Duration(-24 * 60 * 60 * 1000); // -1 day in milliseconds
        assertEquals(expected, result);
    }

}