package org.joda.time.tz;
import org.joda.time.tz.FixedDateTimeZone;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class tz_FixedDateTimeZone_toTimeZone__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToTimeZoneWithStandardFormat() {
        FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone("TestZone", "+05:00", 0, 0);
        java.util.TimeZone timeZone = fixedDateTimeZone.toTimeZone();
        assertEquals("GMT+05:00", timeZone.getID());
    }

    @Test(timeout = 4000)
    public void testToTimeZoneWithUnusualOffset() {
        FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone("TestZone", "TestID", 3600000, 0);
        java.util.TimeZone timeZone = fixedDateTimeZone.toTimeZone();
        assertEquals("TestID", timeZone.getID());
    }

}