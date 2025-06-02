package org.joda.time.chrono;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.JulianChronology;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class chrono_JulianChronology_withZone_DateTimeZone_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithZone_ZoneNotNull_ZoneDifferent() {
        JulianChronology chronology = JulianChronology.getInstance(); // Use the static method to get an instance
        DateTimeZone zone = DateTimeZone.forID("UTC"); // Using a valid time zone
        try {
            Chronology result = chronology.withZone(zone);
            assertSame("Expected a new instance with the specified zone", result, chronology.withZone(zone));
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWithZone_ZoneIsNull() {
        JulianChronology chronology = JulianChronology.getInstance(); // Use the static method to get an instance
        try {
            Chronology result = chronology.withZone(null);
            assertSame("Expected the default instance when zone is null", result, chronology);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWithZone_ZoneIsSame() {
        JulianChronology chronology = JulianChronology.getInstance(); // Use the static method to get an instance
        DateTimeZone zone = chronology.getZone(); // Get the current zone
        try {
            Chronology result = chronology.withZone(zone);
            assertSame("Expected the same instance when zone is the same", result, chronology);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }


}