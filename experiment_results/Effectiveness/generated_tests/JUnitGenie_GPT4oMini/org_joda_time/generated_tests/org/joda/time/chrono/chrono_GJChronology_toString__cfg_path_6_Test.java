package org.joda.time.chrono;
import org.joda.time.chrono.GJChronology;
import org.joda.time.Instant;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class chrono_GJChronology_toString__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testToString() {
        try {
            // Create an instance of GJChronology directly instead of using Proxy
            GJChronology gjChronology = GJChronology.getInstance(DateTimeZone.UTC, 123456789L, 4);

            // Call the toString method
            String result = gjChronology.toString();

            // Expected output format
            String expected = "GJChronology[" + DateTimeZone.UTC.getID() + ",cutover=" + 
                ISODateTimeFormat.dateTime().withChronology(gjChronology.withUTC()).print(123456789L) + 
                ",mdfw=4]";
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}