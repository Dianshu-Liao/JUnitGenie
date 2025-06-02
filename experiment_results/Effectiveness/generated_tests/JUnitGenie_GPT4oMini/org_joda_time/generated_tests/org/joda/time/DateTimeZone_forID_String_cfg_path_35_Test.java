package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forID_String_cfg_path_35_Test {

    @Test(timeout = 4000)
    public void testForID_ValidUTC() {
        DateTimeZone zone = DateTimeZone.forID("UTC");
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForID_ValidUT() {
        DateTimeZone zone = DateTimeZone.forID("UT");
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForID_ValidGMT() {
        DateTimeZone zone = DateTimeZone.forID("GMT");
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForID_ValidZ() {
        DateTimeZone zone = DateTimeZone.forID("Z");
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForID_ValidOffset() {
        String offsetId = "UTC+05:00"; // Corrected offset format
        DateTimeZone zone = DateTimeZone.forID(offsetId);
        assertNotNull(zone);
        // Additional assertions can be made based on expected behavior
    }

    @Test(timeout = 4000)
    public void testForID_InvalidZone() {
        try {
            DateTimeZone.forID("InvalidZone");
            fail("Expected IllegalArgumentException for invalid zone ID");
        } catch (IllegalArgumentException e) {
            assertEquals("The datetime zone id 'InvalidZone' is not recognised", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForID_NullInput() {
        DateTimeZone zone = DateTimeZone.forID(null);
        assertNull(zone); // Corrected to assertNull for null input
    }

}