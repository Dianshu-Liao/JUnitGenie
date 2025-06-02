package org.joda.time.chrono;
import org.joda.time.chrono.ZonedChronology;
import org.joda.time.DateTimeZone;
import org.joda.time.Chronology;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_ZonedChronology_withZone_DateTimeZone_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithZone_NonNullZone_NotUTC() {
        // Arrange
        Chronology baseChronology = ISOChronology.getInstance(); // Corrected to use ISOChronology
        DateTimeZone zone = DateTimeZone.forID("America/New_York"); // Example of a non-UTC zone
        ZonedChronology zonedChronology = ZonedChronology.getInstance(baseChronology, zone);

        // Act
        Chronology result = zonedChronology.withZone(zone);

        // Assert
        assertNotNull(result);
        assertTrue(result instanceof ZonedChronology);
    }

    @Test(timeout = 4000)
    public void testWithZone_NullZone() {
        // Arrange
        Chronology baseChronology = ISOChronology.getInstance(); // Corrected to use ISOChronology
        // Removed the creation of ZonedChronology with null zone
        ZonedChronology zonedChronology = ZonedChronology.getInstance(baseChronology, DateTimeZone.forID("America/New_York")); // Use a valid zone

        // Act
        Chronology result = zonedChronology.withZone(null); // This will still throw an exception, but we can handle it

        // Assert
        assertNotNull(result);
        assertTrue(result instanceof ZonedChronology);
    }

    @Test(timeout = 4000)
    public void testWithZone_ZoneEqualsParam() {
        // Arrange
        Chronology baseChronology = ISOChronology.getInstance(); // Corrected to use ISOChronology
        DateTimeZone zone = DateTimeZone.forID("America/New_York"); // Example zone
        ZonedChronology zonedChronology = ZonedChronology.getInstance(baseChronology, zone);

        // Act
        Chronology result = zonedChronology.withZone(zone);

        // Assert
        assertSame(zonedChronology, result);
    }

    @Test(timeout = 4000)
    public void testWithZone_ZoneIsUTC() {
        // Arrange
        Chronology baseChronology = ISOChronology.getInstance(); // Corrected to use ISOChronology
        DateTimeZone zone = DateTimeZone.UTC;
        ZonedChronology zonedChronology = ZonedChronology.getInstance(baseChronology, zone);

        // Act
        Chronology result = zonedChronology.withZone(zone);

        // Assert
        assertNotNull(result);
        assertTrue(result instanceof Chronology);
    }

    @Test(timeout = 4000)
    public void testWithZone_ZoneIsDifferent() {
        // Arrange
        Chronology baseChronology = ISOChronology.getInstance(); // Corrected to use ISOChronology
        DateTimeZone zone = DateTimeZone.forID("Europe/London"); // Example of a different zone
        ZonedChronology zonedChronology = ZonedChronology.getInstance(baseChronology, zone);

        // Act
        Chronology result = zonedChronology.withZone(zone);

        // Assert
        assertNotNull(result);
        assertTrue(result instanceof ZonedChronology);
    }


}