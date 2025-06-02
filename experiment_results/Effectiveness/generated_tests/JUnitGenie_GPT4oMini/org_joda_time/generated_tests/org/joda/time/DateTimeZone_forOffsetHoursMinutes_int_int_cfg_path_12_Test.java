package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_12_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_HoursOutOfRange() {
        DateTimeZone.forOffsetHoursMinutes(24, 0); // This should throw IllegalArgumentException
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_MinutesOutOfRange() {
        DateTimeZone.forOffsetHoursMinutes(0, 60); // This should throw IllegalArgumentException
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_PositiveHoursNegativeMinutes() {
        DateTimeZone.forOffsetHoursMinutes(1, -1); // This should throw IllegalArgumentException
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ValidInput() {
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(1, 30);
        assertNotNull(zone);
        // Additional assertions can be added to verify the properties of the returned DateTimeZone
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ZeroOffset() {
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(0, 0);
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_ArithmeticException() {
        // This test is to cover the case where an ArithmeticException is thrown
        DateTimeZone.forOffsetHoursMinutes(Integer.MAX_VALUE, 1); // This should throw IllegalArgumentException
    }

}