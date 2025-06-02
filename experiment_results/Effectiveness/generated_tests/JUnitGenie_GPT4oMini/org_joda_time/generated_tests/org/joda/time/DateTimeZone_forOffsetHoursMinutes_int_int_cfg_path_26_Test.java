package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes() {
        // Test case for hoursOffset = 0 and minutesOffset = 0
        DateTimeZone result = DateTimeZone.forOffsetHoursMinutes(0, 0);
        assertEquals(DateTimeZone.UTC, result);
        
        // Test case for hoursOffset = 1 and minutesOffset = 0
        result = DateTimeZone.forOffsetHoursMinutes(1, 0);
        assertEquals(DateTimeZone.forOffsetMillis(60 * 60 * 1000), result);
        
        // Test case for hoursOffset = -1 and minutesOffset = 0
        result = DateTimeZone.forOffsetHoursMinutes(-1, 0);
        assertEquals(DateTimeZone.forOffsetMillis(-60 * 60 * 1000), result);
        
        // Test case for hoursOffset = 0 and minutesOffset = 30
        result = DateTimeZone.forOffsetHoursMinutes(0, 30);
        assertEquals(DateTimeZone.forOffsetMillis(30 * 60 * 1000), result);
        
        // Test case for hoursOffset = 1 and minutesOffset = -30
        result = DateTimeZone.forOffsetHoursMinutes(1, -30);
        assertEquals(DateTimeZone.forOffsetMillis(30 * 60 * 1000 + 60 * 60 * 1000), result);
    }

}