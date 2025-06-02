package org.joda.time.chrono;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.JulianChronology;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_JulianChronology_withZone_DateTimeZone_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithZone_ValidZone() {
        // Arrange
        JulianChronology chronology = JulianChronology.getInstance(); // Corrected constructor usage
        DateTimeZone zone = DateTimeZone.forID("UTC"); // A valid time zone
        DateTimeZone currentZone = chronology.getZone(); // Get the current zone

        // Act
        Chronology result = chronology.withZone(zone);

        // Assert
        assertNotNull(result);
        assertNotEquals(currentZone, zone);
    }

    @Test(timeout = 4000)
    public void testWithZone_NullZone() {
        // Arrange
        JulianChronology chronology = JulianChronology.getInstance(); // Corrected constructor usage
        DateTimeZone zone = null; // Testing with null zone

        // Act
        Chronology result = chronology.withZone(zone);

        // Assert
        assertNotNull(result);
        assertEquals(chronology, result); // Should return the same instance
    }

    @Test(timeout = 4000)
    public void testWithZone_SameZone() {
        // Arrange
        JulianChronology chronology = JulianChronology.getInstance(); // Corrected constructor usage
        DateTimeZone currentZone = chronology.getZone(); // Get the current zone

        // Act
        Chronology result = chronology.withZone(currentZone);

        // Assert
        assertEquals(chronology, result); // Should return the same instance
    }


}