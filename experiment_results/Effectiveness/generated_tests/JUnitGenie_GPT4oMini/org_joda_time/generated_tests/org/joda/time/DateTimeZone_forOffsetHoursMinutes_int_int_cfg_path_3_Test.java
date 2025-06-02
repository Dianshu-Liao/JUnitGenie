package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_3_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_MinutesOutOfRange() {
        // Test case where minutesOffset is out of range
        DateTimeZone.forOffsetHoursMinutes(0, -60);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_HoursOutOfRange() {
        // Test case where hoursOffset is out of range
        DateTimeZone.forOffsetHoursMinutes(24, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_PositiveHoursNegativeMinutes() {
        // Test case where positive hours have negative minutes
        DateTimeZone.forOffsetHoursMinutes(1, -1);
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ValidInput() {
        // Test case with valid input
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(1, 30);
        assertNotNull(zone);
    }

}