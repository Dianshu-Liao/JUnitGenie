package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.LimitChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_LimitChronology_withZone_DateTimeZone_cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testWithZone_NullZone() {
        DateTime lowerLimit = new DateTime(0, DateTimeZone.UTC); // Providing lower limit
        DateTime upperLimit = new DateTime(0, DateTimeZone.UTC); // Providing upper limit
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Use factory method to create LimitChronology
        Chronology result = chronology.withZone(null);
        assertNotNull(result);
        // Additional assertions can be added to verify the properties of the result
    }

    @Test(timeout = 4000)
    public void testWithZone_SameZone() {
        DateTimeZone zone = DateTimeZone.forID("America/New_York");
        DateTime lowerLimit = new DateTime(0, DateTimeZone.UTC); // Providing lower limit
        DateTime upperLimit = new DateTime(0, DateTimeZone.UTC); // Providing upper limit
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Use factory method to create LimitChronology
        Chronology result = chronology.withZone(zone);
        assertSame(chronology, result);
    }

    @Test(timeout = 4000)
    public void testWithZone_UTCZone() {
        DateTimeZone zone = DateTimeZone.UTC;
        DateTime lowerLimit = new DateTime(0, DateTimeZone.UTC); // Providing lower limit
        DateTime upperLimit = new DateTime(0, DateTimeZone.UTC); // Providing upper limit
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Use factory method to create LimitChronology
        Chronology result = chronology.withZone(zone);
        assertNotNull(result);
        // Additional assertions can be added to verify the properties of the result
    }

    @Test(timeout = 4000)
    public void testWithZone_ValidZoneWithLimits() {
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0, DateTimeZone.UTC);
        DateTime upperLimit = new DateTime(2021, 1, 1, 0, 0, DateTimeZone.UTC);
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Use factory method to create LimitChronology
        Chronology result = chronology.withZone(DateTimeZone.forID("Europe/London"));
        assertNotNull(result);
        // Additional assertions can be added to verify the properties of the result
    }

}