package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.LimitChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_LimitChronology_withZone_DateTimeZone_cfg_path_27_Test {

    @Test(timeout = 4000)
    public void testWithZone_NullZone() {
        DateTime lowerLimit = new DateTime(); // Initialize with a valid DateTime
        DateTime upperLimit = new DateTime(); // Initialize with a valid DateTime
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Use ISOChronology
        Chronology result = chronology.withZone(null);
        assertNotNull(result);
        assertEquals(DateTimeZone.getDefault(), result.getZone());
    }

    @Test(timeout = 4000)
    public void testWithZone_SameZone() {
        DateTime lowerLimit = new DateTime(); // Initialize with a valid DateTime
        DateTime upperLimit = new DateTime(); // Initialize with a valid DateTime
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Use ISOChronology
        DateTimeZone zone = chronology.getZone();
        Chronology result = chronology.withZone(zone);
        assertSame(chronology, result);
    }

    @Test(timeout = 4000)
    public void testWithZone_UTCZone() {
        DateTime lowerLimit = new DateTime(); // Initialize with a valid DateTime
        DateTime upperLimit = new DateTime(); // Initialize with a valid DateTime
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Use ISOChronology
        Chronology result = chronology.withZone(DateTimeZone.UTC);
        assertNotNull(result);
        // Additional assertions can be added based on expected behavior
    }

    @Test(timeout = 4000)
    public void testWithZone_LowerLimitNotNull() {
        DateTime lowerLimit = new DateTime(); // Initialize with a valid DateTime
        DateTime upperLimit = new DateTime(); // Initialize with a valid DateTime
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Use ISOChronology
        Chronology result = chronology.withZone(DateTimeZone.UTC);
        assertNotNull(result);
        // Additional assertions can be added based on expected behavior
    }

    @Test(timeout = 4000)
    public void testWithZone_UpperLimitNotNull() {
        DateTime lowerLimit = new DateTime(); // Initialize with a valid DateTime
        DateTime upperLimit = new DateTime(); // Initialize with a valid DateTime
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Use ISOChronology
        Chronology result = chronology.withZone(DateTimeZone.UTC);
        assertNotNull(result);
        // Additional assertions can be added based on expected behavior
    }

    @Test(timeout = 4000)
    public void testWithZone_HandlesException() {
        DateTime lowerLimit = new DateTime(); // Initialize with a valid DateTime
        DateTime upperLimit = new DateTime(); // Initialize with a valid DateTime
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Use ISOChronology
        try {
            Chronology result = chronology.withZone(DateTimeZone.forID("Invalid/Zone"));
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            // Expected exception
        }
    }


}