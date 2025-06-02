package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.chrono.LimitChronology;
import org.joda.time.Chronology;
import org.joda.time.chrono.GregorianChronology;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class chrono_LimitChronology_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        Chronology baseChronology = GregorianChronology.getInstance(); // Use a valid Chronology instance
        DateTime start = new DateTime(0); // Example DateTime instance
        DateTime end = new DateTime(1); // Example DateTime instance
        LimitChronology chrono = LimitChronology.getInstance(baseChronology, start, end);
        assertTrue(chrono.equals(chrono));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        Chronology baseChronology = GregorianChronology.getInstance(); // Use a valid Chronology instance
        DateTime start = new DateTime(0); // Example DateTime instance
        DateTime end = new DateTime(1); // Example DateTime instance
        LimitChronology chrono = LimitChronology.getInstance(baseChronology, start, end);
        assertFalse(chrono.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        Chronology baseChronology = GregorianChronology.getInstance(); // Use a valid Chronology instance
        DateTime start = new DateTime(0); // Example DateTime instance
        DateTime end = new DateTime(1); // Example DateTime instance
        LimitChronology chrono = LimitChronology.getInstance(baseChronology, start, end);
        String differentClassObject = "Not a LimitChronology";
        assertFalse(chrono.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualChronologies() {
        Chronology baseChronology = GregorianChronology.getInstance(); // Use a valid Chronology instance
        DateTime start = new DateTime(0); // Example DateTime instance
        DateTime end = new DateTime(1); // Example DateTime instance
        LimitChronology chrono1 = LimitChronology.getInstance(baseChronology, start, end);
        LimitChronology chrono2 = LimitChronology.getInstance(baseChronology, start, end);
        assertTrue(chrono1.equals(chrono2));
    }

    @Test(timeout = 4000)
    public void testEquals_NonEqualChronologies() {
        Chronology baseChronology = GregorianChronology.getInstance(); // Use a valid Chronology instance
        DateTime start1 = new DateTime(0); // Example DateTime instance
        DateTime end1 = new DateTime(1); // Example DateTime instance
        DateTime start2 = new DateTime(2); // Different DateTime instance
        DateTime end2 = new DateTime(3); // Different DateTime instance
        LimitChronology chrono1 = LimitChronology.getInstance(baseChronology, start1, end1);
        LimitChronology chrono2 = LimitChronology.getInstance(baseChronology, start2, end2);
        assertFalse(chrono1.equals(chrono2));
    }


}