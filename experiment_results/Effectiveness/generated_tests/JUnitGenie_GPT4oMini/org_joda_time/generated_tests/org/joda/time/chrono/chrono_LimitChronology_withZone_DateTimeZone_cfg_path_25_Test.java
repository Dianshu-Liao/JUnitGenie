package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.LimitChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_LimitChronology_withZone_DateTimeZone_cfg_path_25_Test {

    @Test(timeout = 4000)
    public void testWithZone_NullZone() {
        DateTime lowerLimit = new DateTime(0); // Providing a default lower limit
        DateTime upperLimit = new DateTime(Long.MAX_VALUE); // Providing a default upper limit
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Using the static method to get an instance
        try {
            Chronology result = chronology.withZone(null);
            assertNotNull(result);
        } catch (Exception e) {
            fail("Exception should not be thrown for null zone");
        }
    }

    @Test(timeout = 4000)
    public void testWithZone_SameZone() {
        DateTimeZone zone = DateTimeZone.UTC;
        DateTime lowerLimit = new DateTime(0);
        DateTime upperLimit = new DateTime(Long.MAX_VALUE);
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Using the static method to get an instance
        try {
            Chronology result = chronology.withZone(zone);
            assertEquals(chronology, result);
        } catch (Exception e) {
            fail("Exception should not be thrown when zone is the same");
        }
    }

    @Test(timeout = 4000)
    public void testWithZone_UTCZone() {
        DateTimeZone zone = DateTimeZone.UTC;
        DateTime lowerLimit = new DateTime(0);
        DateTime upperLimit = new DateTime(Long.MAX_VALUE);
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Using the static method to get an instance
        try {
            Chronology result = chronology.withZone(zone);
            assertNotNull(result);
            // Additional assertions can be added to verify the state of result
        } catch (Exception e) {
            fail("Exception should not be thrown for UTC zone");
        }
    }

    @Test(timeout = 4000)
    public void testWithZone_ValidLowerLimit() {
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0);
        DateTime upperLimit = new DateTime(2021, 1, 1, 0, 0);
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Using the static method to get an instance
        try {
            Chronology result = chronology.withZone(DateTimeZone.forID("America/New_York"));
            assertNotNull(result);
            // Additional assertions can be added to verify the state of result
        } catch (Exception e) {
            fail("Exception should not be thrown for valid lower limit");
        }
    }

    @Test(timeout = 4000)
    public void testWithZone_ValidUpperLimit() {
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0);
        DateTime upperLimit = new DateTime(2021, 1, 1, 0, 0);
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit); // Using the static method to get an instance
        try {
            Chronology result = chronology.withZone(DateTimeZone.forID("Europe/London"));
            assertNotNull(result);
            // Additional assertions can be added to verify the state of result
        } catch (Exception e) {
            fail("Exception should not be thrown for valid upper limit");
        }
    }

}