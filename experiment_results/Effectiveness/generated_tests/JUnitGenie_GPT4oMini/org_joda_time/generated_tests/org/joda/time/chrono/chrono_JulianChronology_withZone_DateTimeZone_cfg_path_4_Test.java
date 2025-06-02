package org.joda.time.chrono;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.JulianChronology;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_JulianChronology_withZone_DateTimeZone_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWithZone_NullZone() {
        JulianChronology chronology = JulianChronology.getInstance(); // Corrected constructor usage
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
        JulianChronology chronology = JulianChronology.getInstance(); // Corrected constructor usage
        DateTimeZone zone = chronology.getZone();
        try {
            Chronology result = chronology.withZone(zone);
            assertEquals(chronology, result);
        } catch (Exception e) {
            fail("Exception should not be thrown when zone is the same");
        }
    }

    @Test(timeout = 4000)
    public void testWithZone_DifferentZone() {
        JulianChronology chronology = JulianChronology.getInstance(); // Corrected constructor usage
        DateTimeZone newZone = DateTimeZone.forID("UTC");
        try {
            Chronology result = chronology.withZone(newZone);
            assertNotNull(result);
            // Additional assertions can be added here to verify the result
        } catch (Exception e) {
            fail("Exception should not be thrown for a different zone");
        }
    }


}