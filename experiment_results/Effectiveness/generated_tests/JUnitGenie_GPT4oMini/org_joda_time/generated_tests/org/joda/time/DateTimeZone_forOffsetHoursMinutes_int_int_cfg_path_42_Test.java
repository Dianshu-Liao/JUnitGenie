package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_42_Test {

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_throwsIllegalArgumentException() {
        try {
            // Test case to trigger the ArithmeticException leading to IllegalArgumentException
            DateTimeZone.forOffsetHoursMinutes(1, Integer.MAX_VALUE);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Offset is too large", e.getMessage());
        }
    }

}