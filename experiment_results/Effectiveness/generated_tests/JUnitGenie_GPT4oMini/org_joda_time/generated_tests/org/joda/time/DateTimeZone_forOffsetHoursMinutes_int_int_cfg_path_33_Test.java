package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_33_Test {

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_throwsIllegalArgumentException_hoursOutOfRange() {
        try {
            DateTimeZone.forOffsetHoursMinutes(24, 0);
            fail("Expected IllegalArgumentException for hours out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Hours out of range: 24", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_throwsIllegalArgumentException_minutesOutOfRange() {
        try {
            DateTimeZone.forOffsetHoursMinutes(0, 60);
            fail("Expected IllegalArgumentException for minutes out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Minutes out of range: 60", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_throwsIllegalArgumentException_positiveHoursNegativeMinutes() {
        try {
            DateTimeZone.forOffsetHoursMinutes(1, -1);
            fail("Expected IllegalArgumentException for positive hours with negative minutes");
        } catch (IllegalArgumentException e) {
            assertEquals("Positive hours must not have negative minutes: -1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_throwsIllegalArgumentException_offsetTooLarge() {
        try {
            DateTimeZone.forOffsetHoursMinutes(Integer.MAX_VALUE, 0);
            fail("Expected IllegalArgumentException for offset too large");
        } catch (IllegalArgumentException e) {
            assertEquals("Offset is too large", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_validInput() {
        DateTimeZone zone = DateTimeZone.forOffsetHoursMinutes(1, 30);
        assertNotNull(zone);
        // Additional assertions can be added to verify the properties of the returned DateTimeZone
    }

}