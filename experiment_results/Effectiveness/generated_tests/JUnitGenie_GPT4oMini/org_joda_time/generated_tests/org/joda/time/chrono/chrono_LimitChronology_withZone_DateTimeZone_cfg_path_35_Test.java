package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.LimitChronology;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_LimitChronology_withZone_DateTimeZone_cfg_path_35_Test {

    @Test(timeout = 4000)
    public void testWithZone_ValidZone() {
        // Arrange
        DateTimeZone zone = DateTimeZone.forID("America/New_York");
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0, zone);
        DateTime upperLimit = new DateTime(2020, 12, 31, 23, 59, zone);
        LimitChronology chronology = LimitChronology.getInstance(null, lowerLimit, upperLimit); // Using getInstance method

        // Act
        Chronology result = chronology.withZone(zone); // Change LimitChronology to Chronology

        // Assert
        assertNotNull(result);
        assertNotSame(chronology, result);
    }

    @Test(timeout = 4000)
    public void testWithZone_NullZone() {
        // Arrange
        DateTimeZone zone = null;
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0, DateTimeZone.forID("UTC"));
        DateTime upperLimit = new DateTime(2020, 12, 31, 23, 59, DateTimeZone.forID("UTC"));
        LimitChronology chronology = LimitChronology.getInstance(null, lowerLimit, upperLimit); // Using getInstance method

        // Act
        Chronology result = chronology.withZone(zone); // Change LimitChronology to Chronology

        // Assert
        assertNotNull(result);
        assertNotSame(chronology, result);
    }

    @Test(timeout = 4000)
    public void testWithZone_SameZone() {
        // Arrange
        DateTimeZone zone = DateTimeZone.forID("UTC");
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0, zone);
        DateTime upperLimit = new DateTime(2020, 12, 31, 23, 59, zone);
        LimitChronology chronology = LimitChronology.getInstance(null, lowerLimit, upperLimit); // Using getInstance method

        // Act
        Chronology result = chronology.withZone(zone); // Change LimitChronology to Chronology

        // Assert
        assertSame(chronology, result);
    }

    @Test(timeout = 4000)
    public void testWithZone_UTCZone() {
        // Arrange
        DateTimeZone zone = DateTimeZone.UTC;
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0, zone);
        DateTime upperLimit = new DateTime(2020, 12, 31, 23, 59, zone);
        LimitChronology chronology = LimitChronology.getInstance(null, lowerLimit, upperLimit); // Using getInstance method

        // Act
        Chronology result = chronology.withZone(zone); // Change LimitChronology to Chronology

        // Assert
        assertNotNull(result);
        assertNotSame(chronology, result);
    }


}