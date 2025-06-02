package org.joda.time;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.Provider;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forID_String_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testForIDWithValidUTC() {
        String id = "UTC";
        DateTimeZone result = DateTimeZone.forID(id);
        assertEquals(DateTimeZone.UTC, result);
    }

    @Test(timeout = 4000)
    public void testForIDWithValidUT() {
        String id = "UT";
        DateTimeZone result = DateTimeZone.forID(id);
        assertEquals(DateTimeZone.UTC, result);
    }

    @Test(timeout = 4000)
    public void testForIDWithValidGMT() {
        String id = "GMT";
        DateTimeZone result = DateTimeZone.forID(id);
        assertEquals(DateTimeZone.UTC, result);
    }

    @Test(timeout = 4000)
    public void testForIDWithValidZ() {
        String id = "Z";
        DateTimeZone result = DateTimeZone.forID(id);
        assertEquals(DateTimeZone.UTC, result);
    }

    @Test(timeout = 4000)
    public void testForIDWithNull() {
        try {
            DateTimeZone result = DateTimeZone.forID(null);
            assertNotNull(result); // This line should not be reached
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    @Test(timeout = 4000)
    public void testForIDWithUnknownZoneID() {
        try {
            DateTimeZone result = DateTimeZone.forID("InvalidZoneID");
            assertNotNull(result); // This line should not be reached
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals("The datetime zone id 'InvalidZoneID' is not recognised", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForIDWithValidOffset() {
        String id = "GMT+2"; // Testing an offset
        try {
            DateTimeZone result = DateTimeZone.forID(id);
            assertNotNull(result); // Ensure it is not null
            // Add additional checks if necessary
        } catch (Exception e) {
            fail("Expected no exception for valid zone ID: " + id);
        }
    }


}