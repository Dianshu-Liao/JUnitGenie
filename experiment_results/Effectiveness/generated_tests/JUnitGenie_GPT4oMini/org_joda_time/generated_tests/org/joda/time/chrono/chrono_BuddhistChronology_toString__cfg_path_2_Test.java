package org.joda.time.chrono;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class chrono_BuddhistChronology_toString__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToStringWithNullZone() {
        // Create an instance of BuddhistChronology using the default instance
        BuddhistChronology buddhistChronology = BuddhistChronology.getInstance(DateTimeZone.UTC);

        // Call the toString method
        String result = buddhistChronology.toString();

        // Verify the result
        assertEquals("BuddhistChronology[UTC]", result);
    }

}