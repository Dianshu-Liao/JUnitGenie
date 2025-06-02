package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_27_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_HoursOutOfRange() {
        // Test case for hoursOffset < -23
        DateTimeZone.forOffsetHoursMinutes(-24, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_HoursOutOfRangePositive() {
        // Test case for hoursOffset > 23
        DateTimeZone.forOffsetHoursMinutes(24, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_MinutesOutOfRange() {
        // Test case for minutesOffset < -59
        DateTimeZone.forOffsetHoursMinutes(0, -60);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_MinutesOutOfRangePositive() {
        // Test case for minutesOffset > 59
        DateTimeZone.forOffsetHoursMinutes(0, 60);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_PositiveHoursNegativeMinutes() {
        // Test case for positive hours with negative minutes
        DateTimeZone.forOffsetHoursMinutes(1, -1);
    }

}