package org.joda.time.chrono;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ZonedChronology;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class chrono_ZonedChronology_withZone_DateTimeZone_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWithZone_NonNullZone_DifferentFromParam() {
        // Arrange
        Chronology baseChronology = DateTime.now().getChronology(); // Using a base Chronology
        DateTimeZone zone = DateTimeZone.forID("America/New_York"); // Example of a concrete DateTimeZone
        ZonedChronology zonedChronology = ZonedChronology.getInstance(baseChronology, zone); // Correctly initializing ZonedChronology

        // Act
        Chronology result = zonedChronology.withZone(zone);

        // Assert
        assertSame("Expected a new ZonedChronology instance", result, ZonedChronology.getInstance(baseChronology, zone));
    }

    @Test(timeout = 4000)
    public void testWithZone_NonNullZone_SameAsParam() {
        // Arrange
        Chronology baseChronology = DateTime.now().getChronology(); // Using a base Chronology
        DateTimeZone zone = DateTimeZone.UTC; // Default zone for initialization
        ZonedChronology zonedChronology = ZonedChronology.getInstance(baseChronology, zone); // Correctly initializing ZonedChronology
        zone = zonedChronology.getZone(); // Getting the same DateTimeZone

        // Act
        Chronology result = zonedChronology.withZone(zone);

        // Assert
        assertSame("Expected the same instance", result, zonedChronology);
    }

    @Test(timeout = 4000)
    public void testWithZone_NullZone() {
        // Arrange
        Chronology baseChronology = DateTime.now().getChronology(); // Using a base Chronology
        ZonedChronology zonedChronology = ZonedChronology.getInstance(baseChronology, DateTimeZone.UTC); // Correctly initializing ZonedChronology
        DateTimeZone zone = null;

        // Act
        Chronology result = zonedChronology.withZone(zone);

        // Assert
        assertSame("Expected the same instance when zone is null", result, zonedChronology);
    }


}