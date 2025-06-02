package org.joda.time.chrono;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class chrono_BuddhistChronology_toString__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToStringWithoutZone() {
        // Create an instance of BuddhistChronology without using reflection
        BuddhistChronology buddhistChronology = BuddhistChronology.getInstance();

        // Call the toString method and verify the output
        String result = buddhistChronology.toString();
        assertEquals("BuddhistChronology", result);
    }

}