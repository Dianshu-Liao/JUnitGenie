package org.joda.time.chrono;
import org.joda.time.Instant;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GJChronology;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class chrono_GJChronology_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        GJChronology chrono = GJChronology.getInstance(DateTimeZone.UTC, Instant.now().getMillis(), 1); // Changed 0 to 1
        assertTrue(chrono.equals(chrono));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        GJChronology chrono = GJChronology.getInstance(DateTimeZone.UTC, Instant.now().getMillis(), 1); // Changed 0 to 1
        String differentType = "Not a GJChronology";
        assertFalse(chrono.equals(differentType));
    }

    @Test(timeout = 4000)
    public void testEquals_Null() {
        GJChronology chrono = GJChronology.getInstance(DateTimeZone.UTC, Instant.now().getMillis(), 1); // Changed 0 to 1
        assertFalse(chrono.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualChronologies() {
        GJChronology chrono1 = GJChronology.getInstance(DateTimeZone.UTC, Instant.now().getMillis(), 1); // Changed 0 to 1
        GJChronology chrono2 = GJChronology.getInstance(DateTimeZone.UTC, Instant.now().getMillis(), 1); // Changed 0 to 1
        assertTrue(chrono1.equals(chrono2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentChronologies() {
        GJChronology chrono1 = GJChronology.getInstance(DateTimeZone.UTC, Instant.now().getMillis(), 1); // Changed 0 to 1
        GJChronology chrono2 = GJChronology.getInstance(DateTimeZone.UTC, Instant.now().getMillis(), 1); // Changed 0 to 1
        // Modify one of the chronologies to have a different iCutoverMillis
        // Assuming there's a way to set iCutoverMillis via reflection or constructor
        // For example, using reflection to set the private field
        try {
            java.lang.reflect.Field field = GJChronology.class.getDeclaredField("iCutoverMillis");
            field.setAccessible(true);
            field.setLong(chrono2, 123456789L); // Set a different value
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(chrono1.equals(chrono2));
    }


}