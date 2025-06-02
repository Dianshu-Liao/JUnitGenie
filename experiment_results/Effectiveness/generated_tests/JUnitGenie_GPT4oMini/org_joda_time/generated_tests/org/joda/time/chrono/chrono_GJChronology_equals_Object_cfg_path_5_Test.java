package org.joda.time.chrono;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.JulianChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.Instant;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class chrono_GJChronology_equals_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObjectType() {
        // Create instances of JulianChronology and GregorianChronology for the constructor
        JulianChronology julianChronology = JulianChronology.getInstance();
        GregorianChronology gregorianChronology = GregorianChronology.getInstance();
        Instant instant = Instant.now(); // Create an Instant for the constructor

        // Use the appropriate constructor for GJChronology
        DateTimeZone timeZone = DateTimeZone.forID("UTC"); // Specify a DateTimeZone
        // Set the minimum days in the first week to a valid value (1)
        GJChronology chrono = GJChronology.getInstance(timeZone, instant.getMillis(), 1);
        Object differentTypeObject = new Object();
        
        try {
            boolean result = chrono.equals(differentTypeObject);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }


}