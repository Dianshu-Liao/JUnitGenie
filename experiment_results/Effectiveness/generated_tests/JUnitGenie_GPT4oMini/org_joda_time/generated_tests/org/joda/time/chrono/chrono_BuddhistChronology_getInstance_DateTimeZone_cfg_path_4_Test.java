package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_BuddhistChronology_getInstance_DateTimeZone_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetInstanceWithDefaultZone() {
        try {
            // Test with null DateTimeZone to trigger default zone retrieval
            BuddhistChronology chrono = BuddhistChronology.getInstance(null);
            assertNotNull(chrono);
        } catch (Exception e) {
            fail("Exception should not be thrown for null DateTimeZone: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetInstanceWithValidZone() {
        try {
            // Test with a valid DateTimeZone
            DateTimeZone zone = DateTimeZone.forID("Asia/Bangkok");
            BuddhistChronology chrono = BuddhistChronology.getInstance(zone);
            assertNotNull(chrono);
        } catch (Exception e) {
            fail("Exception should not be thrown for valid DateTimeZone: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetInstanceWithInvalidZone() {
        try {
            // Test with an invalid DateTimeZone ID
            DateTimeZone zone = DateTimeZone.forID("Invalid/Zone");
            BuddhistChronology chrono = BuddhistChronology.getInstance(zone);
            assertNotNull(chrono);
        } catch (Exception e) {
            // Expected to throw an exception for invalid zone
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

}