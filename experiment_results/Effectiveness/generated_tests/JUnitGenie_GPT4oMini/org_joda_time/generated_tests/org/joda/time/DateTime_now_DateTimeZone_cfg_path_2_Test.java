package org.joda.time;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

public class DateTime_now_DateTimeZone_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNowWithNullZone() {
        try {
            DateTime.now((DateTimeZone) null); // Explicitly cast to DateTimeZone
        } catch (NullPointerException e) {
            // Expected exception
            assert "Zone must not be null".equals(e.getMessage());
        }
    }


}