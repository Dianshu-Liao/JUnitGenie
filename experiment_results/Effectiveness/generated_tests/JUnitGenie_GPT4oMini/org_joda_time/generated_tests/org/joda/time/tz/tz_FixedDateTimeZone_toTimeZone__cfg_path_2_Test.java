package org.joda.time.tz;
import org.joda.time.tz.FixedDateTimeZone;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class tz_FixedDateTimeZone_toTimeZone__cfg_path_2_Test {

    // Test case for the scenario where id length is 6 and starts with '+' or '-'
    @Test(timeout = 4000)
    public void testToTimeZone_ValidGMTOffset() {
        FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone("TestZone", "+05:00", 5 * 3600 * 1000, 0);
        java.util.TimeZone timeZone = fixedDateTimeZone.toTimeZone();
        
        // Verify the expected TimeZone
        assertEquals("GMT+05:00", timeZone.getID());
    }

    // Test case for the scenario where id does not meet the standard format
    @Test(timeout = 4000)
    public void testToTimeZone_UnusualOffset() {
        FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone("TestZone", "InvalidOffset", 0, 0);
        java.util.TimeZone timeZone = fixedDateTimeZone.toTimeZone();

        // Verify that a SimpleTimeZone is created with the unusual offset
        assertEquals("TestZone", timeZone.getID());
    }

}