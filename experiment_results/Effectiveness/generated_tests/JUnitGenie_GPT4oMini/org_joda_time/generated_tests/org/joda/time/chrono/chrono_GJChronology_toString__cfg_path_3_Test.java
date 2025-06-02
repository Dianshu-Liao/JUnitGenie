package org.joda.time.chrono;
import org.joda.time.chrono.GJChronology;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class chrono_GJChronology_toString__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToString() {
        // Create an instance of GJChronology
        GJChronology gjChronology = GJChronology.getInstance(DateTimeZone.UTC, 0, 4);
        
        // Instead of using reflection to set the private field, we will use a public method if available
        // If no public method is available, we will skip modifying the private field
        // This avoids the AccessControlException related to reflection
        
        // Call the toString method
        String result = gjChronology.toString();

        // Expected output format
        String expected = "GJChronology[UTC,cutover=1970-01-01]";
        assertEquals(expected, result);
    }

}