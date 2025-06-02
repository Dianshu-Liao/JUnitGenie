package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_31_Test {

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_PositiveHoursNegativeMinutes() {
        try {
            DateTimeZone.forOffsetHoursMinutes(1, -1);
            fail("Expected IllegalArgumentException for positive hours with negative minutes");
        } catch (IllegalArgumentException e) {
            assertEquals("Positive hours must not have negative minutes: -1", e.getMessage());
        }
    }

}