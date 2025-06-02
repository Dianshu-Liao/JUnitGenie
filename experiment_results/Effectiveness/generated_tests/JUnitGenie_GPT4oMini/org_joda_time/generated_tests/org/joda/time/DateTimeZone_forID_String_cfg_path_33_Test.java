package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forID_String_cfg_path_33_Test {

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
        assertEquals(DateTimeZone.UTC, zone); // This is correct as per the original intent
    }

    @Test(timeout = 4000)
    public void testForID_ValidZ() {
        DateTimeZone zone = DateTimeZone.forID("Z");
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForID_ValidOffset() {
        String id = "UTC+05:00"; // Corrected the offset format
        DateTimeZone zone = DateTimeZone.forID(id);
        assertNotNull(zone);
    }

    @Test(timeout = 4000)
    public void testForID_InvalidID() {
        try {
            DateTimeZone.forID("InvalidID");
            fail("Expected IllegalArgumentException for invalid ID");
        } catch (IllegalArgumentException e) {
            assertEquals("The datetime zone id 'InvalidID' is not recognised", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForID_NullID() {
        DateTimeZone zone = DateTimeZone.forID(null);
        assertNotNull(zone);
        assertEquals(DateTimeZone.UTC, zone); // This is correct as per the original intent
    }


}