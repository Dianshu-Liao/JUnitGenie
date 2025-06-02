package org.joda.time.chrono;
import org.junit.Test;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GJChronology;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class chrono_GJChronology_equals_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        GJChronology chrono = GJChronology.getInstance(DateTimeZone.UTC);
        assertTrue(chrono.equals(chrono));
    }
    
    @Test(timeout = 4000)
    public void testEquals_DifferentObjectNotGJChronology() {
        GJChronology chrono = GJChronology.getInstance(DateTimeZone.UTC);
        Object notGJChronology = new Object();
        assertFalse(chrono.equals(notGJChronology));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentGJChronology() {
        GJChronology chrono1 = GJChronology.getInstance(DateTimeZone.UTC);
        GJChronology chrono2 = GJChronology.getInstance(DateTimeZone.UTC);
        
        assertFalse(chrono1.equals(chrono2));
    }
    
    @Test(timeout = 4000)
    public void testEquals_SameAttributes() {
        GJChronology chrono1 = GJChronology.getInstance(DateTimeZone.UTC);
        GJChronology chrono2 = GJChronology.getInstance(DateTimeZone.UTC);
        
        assertTrue(chrono1.equals(chrono2));
    }

}