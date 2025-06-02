package org.joda.time;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_forID_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testForID_NullID_ReturnsDefault() {
        try {
            DateTimeZone result = DateTimeZone.forID(null);
            assertNotNull(result);  // We expect to get the default zone.
        } catch (Exception e) {
            fail("Expected no exception but got: " + e.getMessage());
        }
    }

    // Other test cases for different inputs can be added here.

}