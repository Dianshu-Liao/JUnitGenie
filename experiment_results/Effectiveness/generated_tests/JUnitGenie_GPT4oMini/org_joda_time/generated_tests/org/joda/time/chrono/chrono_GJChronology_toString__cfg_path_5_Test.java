package org.joda.time.chrono;
import org.joda.time.chrono.GJChronology;
import org.joda.time.Instant;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class chrono_GJChronology_toString__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testToString() {
        try {
            // Create an instance of GJChronology using the public method
            DateTimeZone timeZone = DateTimeZone.UTC; // Use UTC as the time zone
            GJChronology gjChronology = GJChronology.getInstance(
                timeZone,
                new Instant(-12219292800000L), // Use the static final DEFAULT_CUTOVER value
                0 // The second parameter is the cutover year, set to 0 for default
            );

            // Call the toString method
            String result = gjChronology.toString();
            
            // Expected output format
            DateTimeFormatter formatter = ISODateTimeFormat.dateTime().withChronology(gjChronology.withUTC());
            String expected = "GJChronology[" + DateTimeZone.UTC.getID() + ",cutover=" + formatter.print(-12219292800000L) + "]";
            
            // Assert the result
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}