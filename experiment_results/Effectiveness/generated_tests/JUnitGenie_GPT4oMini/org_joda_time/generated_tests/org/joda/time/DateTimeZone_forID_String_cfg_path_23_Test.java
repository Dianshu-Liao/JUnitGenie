package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forID_String_cfg_path_23_Test {
    
    @Test(timeout = 4000)
    public void testForID_Utc() {
        DateTimeZone result = DateTimeZone.forID("UTC");
        assertEquals(DateTimeZone.UTC, result);
    }

    @Test(timeout = 4000)
    public void testForID_Null() {
        DateTimeZone result = DateTimeZone.forID(null);
        assertNotNull(result); // We assume getDefault() provides a non-null object
    }

    @Test(timeout = 4000)
    public void testForID_GMT() {
        DateTimeZone result = DateTimeZone.forID("GMT");
        assertEquals(DateTimeZone.forID("Etc/GMT"), result); // Corrected to match the actual ID
    }

    @Test(timeout = 4000)
    public void testForID_UT() {
        DateTimeZone result = DateTimeZone.forID("UT");
        assertEquals(DateTimeZone.UTC, result);
    }

    @Test(timeout = 4000)
    public void testForID_Z() {
        DateTimeZone result = DateTimeZone.forID("Z");
        assertEquals(DateTimeZone.UTC, result);
    }

    @Test(timeout = 4000)
    public void testForID_Invalid() {
        try {
            DateTimeZone.forID("InvalidID");
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testForID_PositiveOffset() {
        DateTimeZone result = DateTimeZone.forID("UTC+02:00"); // Corrected format for positive offset
        assertNotNull(result);
        // Add further assertions if necessary to validate the offset
    }

    @Test(timeout = 4000)
    public void testForID_NegativeOffset() {
        DateTimeZone result = DateTimeZone.forID("UTC-02:00"); // Corrected format for negative offset
        assertNotNull(result);
        // Add further assertions if necessary to validate the offset
    }

    // Additional cases can be implemented for edge cases and various string formats.


}