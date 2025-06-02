package org.joda.time.chrono;
import static org.junit.Assert.assertTrue;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GJChronology;
import org.joda.time.Instant;
import org.junit.Test;

public class chrono_GJChronology_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        GJChronology chrono = GJChronology.getInstance(DateTimeZone.UTC, Instant.now());
        assertTrue(chrono.equals(chrono)); // Testing equals with same object
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        GJChronology chrono = GJChronology.getInstance(DateTimeZone.UTC, Instant.now());
        assertTrue(!chrono.equals(new Object())); // Testing equals with different type
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentChronologies() {
        GJChronology chrono1 = GJChronology.getInstance(DateTimeZone.UTC, Instant.now());
        GJChronology chrono2 = GJChronology.getInstance(DateTimeZone.UTC, Instant.now());
        assertTrue(chrono1.equals(chrono2)); // Testing equals with equal GJChronology objects
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentZones() {
        GJChronology chrono1 = GJChronology.getInstance(DateTimeZone.UTC, Instant.now());
        GJChronology chrono2 = GJChronology.getInstance(DateTimeZone.UTC, Instant.now().plus(1)); // Changed to plus method
        assertTrue(!chrono1.equals(chrono2)); // Testing equals with different GJChronology objects
    }

    @Test(timeout = 4000)
    public void testEquals_EqualCutoverMillis() {
        GJChronology chrono1 = GJChronology.getInstance(DateTimeZone.UTC, Instant.now());
        GJChronology chrono2 = GJChronology.getInstance(DateTimeZone.UTC, Instant.now());
        assertTrue(chrono1.equals(chrono2)); // Testing equals where cutoverMillis should be equal
    }


}