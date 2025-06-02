package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_50_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_HoursOutOfRange() {
        DateTimeZone.forOffsetHoursMinutes(24, 0); // Hours out of range
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_MinutesOutOfRange() {
        DateTimeZone.forOffsetHoursMinutes(0, 60); // Minutes out of range
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_PositiveHoursNegativeMinutes() {
        DateTimeZone.forOffsetHoursMinutes(1, -1); // Positive hours must not have negative minutes
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ZeroOffset() {
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(0, 0);
        assertEquals(DateTimeZone.UTC, zone); // Expect UTC for 0,0 offset
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ValidOffset() {
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(5, 30);
        assertNotNull(zone); // Should not be null
        // Further assertions can be added to validate the offset calculations
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_ArithmeticException() {
        // Test to cause an ArithmeticsException to be thrown
        DateTimeZone.forOffsetHoursMinutes(Integer.MAX_VALUE, 1); // This should lead to an IllegalArgumentException
    }

}