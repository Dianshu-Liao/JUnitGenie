package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.LimitChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_BuddhistChronology_getInstance_DateTimeZone_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetInstanceWithValidZone() {
        DateTimeZone zone = DateTimeZone.forID("Asia/Bangkok");
        BuddhistChronology chrono = null;
        try {
            chrono = BuddhistChronology.getInstance(zone);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
        assertNotNull("Chronology should not be null", chrono);
    }

    @Test(timeout = 4000)
    public void testGetInstanceWithNullZone() {
        BuddhistChronology chrono = null;
        try {
            chrono = BuddhistChronology.getInstance(null);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
        assertNotNull("Chronology should not be null when zone is null", chrono);
    }

    @Test(timeout = 4000)
    public void testGetInstanceWithDifferentZones() {
        DateTimeZone zone1 = DateTimeZone.forID("Europe/London");
        DateTimeZone zone2 = DateTimeZone.forID("America/New_York");
        BuddhistChronology chrono1 = null;
        BuddhistChronology chrono2 = null;
        try {
            chrono1 = BuddhistChronology.getInstance(zone1);
            chrono2 = BuddhistChronology.getInstance(zone2);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
        assertNotNull("Chronology for zone1 should not be null", chrono1);
        assertNotNull("Chronology for zone2 should not be null", chrono2);
        assertNotSame("Chronologies for different zones should not be the same", chrono1, chrono2);
    }

}