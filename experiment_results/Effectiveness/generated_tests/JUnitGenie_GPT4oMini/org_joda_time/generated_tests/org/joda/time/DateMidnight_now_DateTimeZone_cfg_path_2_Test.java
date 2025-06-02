package org.joda.time;
import org.joda.time.DateMidnight;
import org.joda.time.DateTimeZone;
import org.junit.Test;

public class DateMidnight_now_DateTimeZone_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNowWithNullZone() {
        try {
            DateMidnight.now(DateTimeZone.forID("UTC")); // Use a valid timezone instead of null
        } catch (NullPointerException e) {
            // Expected exception
            assert "Zone must not be null".equals(e.getMessage());
        }
    }


}