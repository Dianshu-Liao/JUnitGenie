package org.joda.time.chrono;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_ISOChronology_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        ISOChronology chrono = ISOChronology.getInstance(DateTimeZone.UTC);
        assertTrue(chrono.equals(chrono));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        ISOChronology chrono = ISOChronology.getInstance(DateTimeZone.UTC);
        String notChrono = "Not an ISOChronology";
        assertFalse(chrono.equals(notChrono));
    }

    @Test(timeout = 4000)
    public void testEquals_Null() {
        ISOChronology chrono = ISOChronology.getInstance(DateTimeZone.UTC);
        assertFalse(chrono.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentChronologies() {
        ISOChronology chrono1 = ISOChronology.getInstance(DateTimeZone.UTC);
        ISOChronology chrono2 = ISOChronology.getInstance(DateTimeZone.forID("America/New_York"));
        assertFalse(chrono1.equals(chrono2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameChronology() {
        ISOChronology chrono1 = ISOChronology.getInstance(DateTimeZone.UTC);
        ISOChronology chrono2 = ISOChronology.getInstance(DateTimeZone.UTC);
        assertTrue(chrono1.equals(chrono2));
    }

}