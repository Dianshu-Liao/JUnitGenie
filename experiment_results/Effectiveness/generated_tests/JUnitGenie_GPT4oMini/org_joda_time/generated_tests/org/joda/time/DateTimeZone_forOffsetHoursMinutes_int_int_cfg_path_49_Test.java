package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_49_Test {

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ValidInput() {
        // Test with valid hours and minutes
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(1, 30);
        assertNotNull(zone);
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ZeroOffset() {
        // Test with zero offset
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(0, 0);
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_HoursOutOfRange() {
        // Test with hours out of range
        DateTimeZone.forOffsetHoursMinutes(24, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_MinutesOutOfRange() {
        // Test with minutes out of range
        DateTimeZone.forOffsetHoursMinutes(0, 60);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_PositiveHoursNegativeMinutes() {
        // Test with positive hours and negative minutes
        DateTimeZone.forOffsetHoursMinutes(1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_ArithmeticException() {
        // Test to trigger ArithmeticException
        try {
            DateTimeZone.forOffsetHoursMinutes(Integer.MAX_VALUE, 0);
        } catch (IllegalArgumentException e) {
            // Handle the exception
            throw e;
        }
    }

}