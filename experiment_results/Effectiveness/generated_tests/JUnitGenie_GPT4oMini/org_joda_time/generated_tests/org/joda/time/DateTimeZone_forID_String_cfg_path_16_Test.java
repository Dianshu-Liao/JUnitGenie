package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forID_String_cfg_path_16_Test {

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
        DateTimeZone zone = DateTimeZone.forID("+05:00");
        assertNotNull(zone);
    }

    @Test(timeout = 4000)
    public void testForID_InvalidZone() {
        try {
            DateTimeZone.forID("InvalidZone");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("The datetime zone id 'InvalidZone' is not recognised", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForID_NullInput() {
        DateTimeZone zone = DateTimeZone.forID(null);
        assertNull(zone);
    }


}