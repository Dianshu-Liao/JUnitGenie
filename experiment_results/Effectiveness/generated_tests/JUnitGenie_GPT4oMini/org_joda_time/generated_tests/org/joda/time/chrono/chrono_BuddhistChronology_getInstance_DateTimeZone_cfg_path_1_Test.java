package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.LimitChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_BuddhistChronology_getInstance_DateTimeZone_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetInstanceWithValidZone() {
        DateTimeZone zone = DateTimeZone.forID("Asia/Bangkok");
        BuddhistChronology chrono = BuddhistChronology.getInstance(zone);
        assertNotNull(chrono);
    }

    @Test(timeout = 4000)
    public void testGetInstanceWithNullZone() {
        BuddhistChronology chrono = BuddhistChronology.getInstance(null);
        assertNotNull(chrono);
    }

    @Test(timeout = 4000)
    public void testGetInstanceWithDifferentZones() {
        DateTimeZone zone1 = DateTimeZone.forID("Europe/London");
        DateTimeZone zone2 = DateTimeZone.forID("America/New_York");
        
        BuddhistChronology chrono1 = BuddhistChronology.getInstance(zone1);
        BuddhistChronology chrono2 = BuddhistChronology.getInstance(zone2);
        
        assertNotNull(chrono1);
        assertNotNull(chrono2);
        assertNotSame(chrono1, chrono2);
    }

    @Test(timeout = 4000)
    public void testGetInstanceCaching() {
        DateTimeZone zone = DateTimeZone.forID("Asia/Tokyo");
        BuddhistChronology chrono1 = BuddhistChronology.getInstance(zone);
        BuddhistChronology chrono2 = BuddhistChronology.getInstance(zone);
        
        assertSame(chrono1, chrono2);
    }

    @Test(timeout = 4000)
    public void testGetInstanceWithLowerLimit() {
        DateTimeZone zone = DateTimeZone.forID("Asia/Kolkata");
        BuddhistChronology chrono = BuddhistChronology.getInstance(zone);
        DateTime lowerLimit = new DateTime(1, 1, 1, 0, 0, 0, 0, chrono);
        
        // Assuming we can check the lower limit in some way
        // This is a placeholder for actual validation logic
        assertNotNull(lowerLimit);
    }

}