package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTimeZone_forID_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testForID_UTC() {
        DateTimeZone result = DateTimeZone.forID("UTC");
        assertEquals(DateTimeZone.UTC, result);
    }

    @Test(timeout = 4000)
    public void testForID_Null() {
        DateTimeZone result = DateTimeZone.forID(null);
        assertEquals(DateTimeZone.UTC, result);
    }

    @Test(timeout = 4000)
    public void testForID_Invalid() {
        try {
            DateTimeZone.forID("InvalidID");
        } catch (IllegalArgumentException e) {
            assertEquals("The datetime zone id 'InvalidID' is not recognised", e.getMessage());
        }
    }

}