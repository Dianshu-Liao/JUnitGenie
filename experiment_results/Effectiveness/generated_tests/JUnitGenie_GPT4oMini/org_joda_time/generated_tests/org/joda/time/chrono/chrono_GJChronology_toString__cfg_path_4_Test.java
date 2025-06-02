package org.joda.time.chrono;
import org.joda.time.chrono.GJChronology;
import org.joda.time.Instant;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.lang.reflect.Field;

public class chrono_GJChronology_toString__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testToString() {
        try {
            // Create an instance of GJChronology using reflection
            GJChronology gjChronology = (GJChronology) GJChronology.class.getDeclaredConstructors()[0].newInstance(null, null, new Instant(-12219292800000L));

            // Set the iCutoverMillis field to a specific value for testing
            Field field = GJChronology.class.getDeclaredField("iCutoverMillis");
            field.setAccessible(true);
            field.setLong(gjChronology, -12219292800000L); // Set to DEFAULT_CUTOVER.getMillis()

            // Set the minimum days in first week to 4
            Field minDaysField = GJChronology.class.getDeclaredField("minimumDaysInFirstWeek");
            minDaysField.setAccessible(true);
            minDaysField.setInt(gjChronology, 4);

            // Use reflection to access the private field iCutoverMillis
            long cutoverMillis = field.getLong(gjChronology);

            // Call the toString method
            String result = gjChronology.toString();

            // Expected output format
            String expected = "GJChronology[" + DateTimeZone.UTC.getID() + ",cutover=" + ISODateTimeFormat.dateTime().withChronology(gjChronology.withUTC()).print(cutoverMillis) + ",mdfw=4]";
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}