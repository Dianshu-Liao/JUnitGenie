package org.joda.time.chrono;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.LimitChronology;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_LimitChronology_withZone_DateTimeZone_cfg_path_36_Test {

    @Test(timeout = 4000)
    public void testWithZone_NullZone() {
        LimitChronology chronology = LimitChronology.getInstance(null, null, null);
        try {
            Chronology result = chronology.withZone(null);
            assertNotNull(result);
            assertEquals(chronology, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for null zone");
        }
    }

    @Test(timeout = 4000)
    public void testWithZone_SameZone() {
        LimitChronology chronology = LimitChronology.getInstance(null, null, null);
        DateTimeZone zone = DateTimeZone.forID("UTC");
        try {
            Chronology result = chronology.withZone(zone);
            assertNotNull(result);
            assertEquals(chronology, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for same zone");
        }
    }

    @Test(timeout = 4000)
    public void testWithZone_ValidZone() {
        LimitChronology chronology = LimitChronology.getInstance(null, null, null);
        DateTimeZone zone = DateTimeZone.forID("America/New_York");
        try {
            Chronology result = chronology.withZone(zone);
            assertNotNull(result);
            // Additional assertions can be added here based on expected behavior
        } catch (Exception e) {
            fail("Exception should not be thrown for valid zone");
        }
    }


}