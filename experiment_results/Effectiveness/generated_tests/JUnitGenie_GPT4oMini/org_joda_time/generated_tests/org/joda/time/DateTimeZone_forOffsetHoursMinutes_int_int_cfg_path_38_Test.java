package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_38_Test {

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ValidInputs() {
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(2, 30);
        assertNotNull(zone);
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ZeroOffset() {
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(0, 0);
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_HoursOutOfRange() {
        DateTimeZone.forOffsetHoursMinutes(24, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_NegativeHoursOutOfRange() {
        DateTimeZone.forOffsetHoursMinutes(-24, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_MinutesOutOfRange() {
        DateTimeZone.forOffsetHoursMinutes(0, 60);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_NegativeMinutesOutOfRange() {
        DateTimeZone.forOffsetHoursMinutes(0, -60);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_PositiveHoursNegativeMinutes() {
        DateTimeZone.forOffsetHoursMinutes(2, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_OffsetTooLarge() {
        try {
            DateTimeZone.forOffsetHoursMinutes(Integer.MAX_VALUE, Integer.MAX_VALUE);
        } catch (IllegalArgumentException ex) {
            assertEquals("Offset is too large", ex.getMessage());
            throw ex; // Rethrow to satisfy expected exception
        }
    }

}