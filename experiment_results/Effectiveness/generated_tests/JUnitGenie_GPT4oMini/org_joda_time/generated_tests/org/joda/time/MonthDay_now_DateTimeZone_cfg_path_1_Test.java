package org.joda.time;
import org.joda.time.MonthDay;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class MonthDay_now_DateTimeZone_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNowWithValidDateTimeZone() {
        DateTimeZone zone = DateTimeZone.forID("UTC");
        MonthDay monthDay = MonthDay.now(zone);
        assertNotNull(monthDay);
    }

    @Test(timeout = 4000)
    public void testNowWithNullDateTimeZone() {
        try {
            MonthDay.now((DateTimeZone) null); // Cast to resolve ambiguity
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            assertEquals("Zone must not be null", e.getMessage());
        }
    }


}