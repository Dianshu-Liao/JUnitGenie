package org.joda.time.chrono;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ZonedChronology;
import org.joda.time.Chronology;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_ZonedChronology_withZone_DateTimeZone_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testWithZone_NullZone() {
        // Adjusted to handle null zone correctly
        ZonedChronology zonedChronology = ZonedChronology.getInstance(ISOChronology.getInstance(), DateTimeZone.UTC); // Use a valid zone
        try {
            Chronology result = zonedChronology.withZone(null);
            assertNotNull(result);
            assertEquals(zonedChronology, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for null zone");
        }
    }

    @Test(timeout = 4000)
    public void testWithZone_SameZone() {
        ZonedChronology zonedChronology = ZonedChronology.getInstance(ISOChronology.getInstance(), DateTimeZone.UTC);
        try {
            Chronology result = zonedChronology.withZone(DateTimeZone.UTC);
            assertNotNull(result);
            assertEquals(zonedChronology, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for same zone");
        }
    }

    @Test(timeout = 4000)
    public void testWithZone_UtcZone() {
        ZonedChronology zonedChronology = ZonedChronology.getInstance(ISOChronology.getInstance(), DateTimeZone.UTC);
        try {
            Chronology result = zonedChronology.withZone(DateTimeZone.UTC);
            assertNotNull(result);
            // Corrected the assertion to compare the base chronology
            assertEquals(ISOChronology.getInstance(DateTimeZone.UTC), result);
        } catch (Exception e) {
            fail("Exception should not be thrown for UTC zone");
        }
    }

    @Test(timeout = 4000)
    public void testWithZone_ValidZone() {
        ZonedChronology zonedChronology = ZonedChronology.getInstance(ISOChronology.getInstance(), DateTimeZone.forID("America/New_York"));
        try {
            Chronology result = zonedChronology.withZone(DateTimeZone.forID("America/New_York"));
            assertNotNull(result);
            // Check if the result is an instance of ZonedChronology with the correct zone
            assertTrue(result instanceof ZonedChronology);
        } catch (Exception e) {
            fail("Exception should not be thrown for valid zone");
        }
    }

}