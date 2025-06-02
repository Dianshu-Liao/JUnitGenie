package org.joda.time;
import org.joda.time.Duration;
import org.joda.time.field.FieldUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Duration_standardDays_long_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testStandardDaysWithNonZeroDays() {
        long days = 1; // Non-negative long value
        Duration expectedDuration = new Duration(FieldUtils.safeMultiply(days, 86400000)); // 1 day in milliseconds
        Duration actualDuration = Duration.standardDays(days);
        assertEquals(expectedDuration, actualDuration);
    }

    @Test(timeout = 4000)
    public void testStandardDaysWithZeroDays() {
        long days = 0; // Non-negative long value
        Duration expectedDuration = Duration.ZERO; // Expected to return ZERO
        Duration actualDuration = Duration.standardDays(days);
        assertEquals(expectedDuration, actualDuration);
    }

    @Test(timeout = 4000)
    public void testStandardDaysWithLargeDays() {
        long days = 1000; // Non-negative long value
        Duration expectedDuration = new Duration(FieldUtils.safeMultiply(days, 86400000)); // 1000 days in milliseconds
        Duration actualDuration = Duration.standardDays(days);
        assertEquals(expectedDuration, actualDuration);
    }

    @Test(timeout = 4000)
    public void testStandardDaysWithNegativeDays() {
        long days = -1; // Invalid case, should not be allowed
        try {
            Duration actualDuration = Duration.standardDays(days);
        } catch (IllegalArgumentException e) {
            // Expected exception for negative days
        }
    }

}