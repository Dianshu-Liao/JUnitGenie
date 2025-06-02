package org.joda.time.chrono;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_BuddhistChronology_getInstance_DateTimeZone_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetInstanceWithNonNullZone() {
        DateTimeZone zone = DateTimeZone.forID("Asia/Tokyo"); // Valid DateTimeZone
        BuddhistChronology chrono = BuddhistChronology.getInstance(zone);
        assertNotNull(chrono);
    }

    @Test(timeout = 4000)
    public void testGetInstanceWithNullZone() {
        BuddhistChronology chrono = null;
        try {
            chrono = BuddhistChronology.getInstance(null);
        } catch (Exception e) {
            fail("Exception should not be thrown when zone is null");
        }
        assertNotNull(chrono);
    }

}