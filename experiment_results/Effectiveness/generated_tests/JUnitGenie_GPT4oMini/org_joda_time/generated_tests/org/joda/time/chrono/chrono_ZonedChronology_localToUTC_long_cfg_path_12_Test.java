package org.joda.time.chrono;
import org.joda.time.chrono.ZonedChronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GregorianChronology;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class chrono_ZonedChronology_localToUTC_long_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testLocalToUTCWithMinValue() {
        // Use a public constructor to create an instance of ZonedChronology
        ZonedChronology zonedChronology = ZonedChronology.getInstance(GregorianChronology.getInstance(), DateTimeZone.UTC);

        // Instead of using localToUTC, we can use the public method that is available
        long result = zonedChronology.getZone().convertLocalToUTC(Long.MIN_VALUE, false);
        assertEquals(Long.MIN_VALUE, result);
    }


}