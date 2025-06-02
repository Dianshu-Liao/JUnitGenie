package org.joda.time.chrono;
import org.joda.time.chrono.GJChronology;
import org.joda.time.Instant;
import org.joda.time.DateTimeZone;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class chrono_GJChronology_toString__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToString_withDifferentMinimumDaysInFirstWeek() {
        try {
            // Create an instance of GJChronology directly instead of using Proxy
            GJChronology gjChronology = GJChronology.getInstance(DateTimeZone.UTC, 123456789L, 5);

            // Call the toString method
            String result = gjChronology.toString();

            // Expected output
            String expected = "GJChronology[UTC,cutover=1970-01-01T00:02:03.456Z,mdfw=5]";
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}