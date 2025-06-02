package org.joda.time.chrono;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;

public class chrono_BuddhistChronology_getInstance_DateTimeZone_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetInstance_WithValidDateTimeZone() {
        try {
            DateTimeZone zone = DateTimeZone.forID("Asia/Bangkok"); // Example of a valid DateTimeZone
            BuddhistChronology chrono = BuddhistChronology.getInstance(zone);
            assertNotNull("Expected non-null BuddhistChronology instance.", chrono);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetInstance_WithNullDateTimeZone() {
        try {
            BuddhistChronology chrono = BuddhistChronology.getInstance(null);
            assertNotNull("Expected non-null BuddhistChronology instance when null zone is provided.", chrono);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Additional test cases can be added here as necessary

}