package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forOffsetHoursMinutes_int_int_cfg_path_4_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_WhenMinutesAreOutOfRange_ThenThrowsException() {
        DateTimeZone.forOffsetHoursMinutes(1, 60); // Testing with minutes out of range
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_WhenMinutesAreNegativeAndHoursPositive_ThenThrowsException() {
        DateTimeZone.forOffsetHoursMinutes(1, -1); // Positive hours with negative minutes
    }

    @Test(timeout = 4000)
    public void testForOffsetHoursMinutes_WhenValidOffsets_ShouldReturnDateTimeZone() {
        DateTimeZone timeZone = DateTimeZone.forOffsetHoursMinutes(1, 30); // Test with valid offsets
        assertNotNull(timeZone);
        
        // Further assertions can be added here to verify the characteristics of the returned DateTimeZone
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_WhenHoursAreOutOfRange_ThenThrowsException() {
        DateTimeZone.forOffsetHoursMinutes(-24, 0); // Testing with hours out of range
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOffsetHoursMinutes_WhenMinutesAreNegative_ThenThrowsException() {
        DateTimeZone.forOffsetHoursMinutes(0, -60); // Testing with negative minutes
    }


}