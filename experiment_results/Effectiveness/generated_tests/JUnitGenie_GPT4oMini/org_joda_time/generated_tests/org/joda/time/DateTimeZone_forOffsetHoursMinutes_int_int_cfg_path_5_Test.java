package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_5_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_PositiveHoursNegativeMinutes() {
        // This test case is designed to cover the path where positive hours are provided with negative minutes.
        DateTimeZone.forOffsetHoursMinutes(1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_HoursOutOfRange() {
        // This test case is designed to cover the path where hoursOffset is out of the valid range.
        DateTimeZone.forOffsetHoursMinutes(24, 0); // hoursOffset > 23
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_MinutesOutOfRange() {
        // This test case is designed to cover the path where minutesOffset is out of the valid range.
        DateTimeZone.forOffsetHoursMinutes(0, 60); // minutesOffset > 59
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_ValidInput() {
        // This test case is designed to cover the path where valid hours and minutes are provided.
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(1, 30);
        assertNotNull(zone);
    }

}