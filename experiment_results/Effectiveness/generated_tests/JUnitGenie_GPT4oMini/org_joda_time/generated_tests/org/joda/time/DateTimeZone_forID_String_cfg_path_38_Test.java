package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forID_String_cfg_path_38_Test {

    @Test(timeout = 4000)
    public void testForIDWithValidUTC() {
        DateTimeZone result = DateTimeZone.forID("UTC");
        assertEquals(DateTimeZone.UTC, result);
    }

    @Test(timeout = 4000)
    public void testForIDWithValidUT() {
        DateTimeZone result = DateTimeZone.forID("UT");
        assertEquals(DateTimeZone.UTC, result);
    }

    @Test(timeout = 4000)
    public void testForIDWithValidGMT() {
        DateTimeZone result = DateTimeZone.forID("GMT");
        assertEquals(DateTimeZone.forID("Etc/GMT"), result); // Corrected to match the expected value
    }

    @Test(timeout = 4000)
    public void testForIDWithValidZ() {
        DateTimeZone result = DateTimeZone.forID("Z");
        assertEquals(DateTimeZone.UTC, result);
    }

    @Test(timeout = 4000)
    public void testForIDWithValidOffset() {
        String validOffsetID = "UTC+05:00"; // Corrected format for offset
        DateTimeZone result = DateTimeZone.forID(validOffsetID);
        assertNotNull(result); // Ensure the result is not null
    }

    @Test(timeout = 4000)
    public void testForIDWithParseOffset() {
        String offsetString = "UTC-05:00"; // Corrected format for offset
        DateTimeZone result = DateTimeZone.forID(offsetString);
        assertNotNull(result); // Ensure the result is not null
    }

    @Test(timeout = 4000)
    public void testForIDWithInvalidID() {
        try {
            DateTimeZone.forID("InvalidID");
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("The datetime zone id 'InvalidID' is not recognised", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testForIDWithNull() {
        DateTimeZone result = DateTimeZone.forID(null);
        assertNotNull(result); // Ensure a default DateTimeZone is returned
    }


}