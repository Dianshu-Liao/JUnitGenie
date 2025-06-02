package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.LimitChronology;
import org.joda.time.chrono.GregorianChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_LimitChronology_withZone_DateTimeZone_cfg_path_33_Test {

    @Test(timeout = 4000)
    public void testWithZone() {
        // Arrange
        DateTimeZone zone = DateTimeZone.forID("America/New_York"); // A valid non-null DateTimeZone
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0, DateTimeZone.UTC);
        DateTime upperLimit = new DateTime(2021, 1, 1, 0, 0, DateTimeZone.UTC);
        LimitChronology baseChronology = LimitChronology.getInstance(GregorianChronology.getInstance(DateTimeZone.UTC), lowerLimit, upperLimit); // Use LimitChronology with GregorianChronology

        // Act
        LimitChronology result = null;
        try {
            result = (LimitChronology) baseChronology.withZone(zone);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertNotNull(result);
        assertNotSame(baseChronology, result);
    }

    @Test(timeout = 4000)
    public void testWithZone_NullZone() {
        // Arrange
        DateTimeZone zone = null; // Testing with null zone
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0, DateTimeZone.UTC);
        DateTime upperLimit = new DateTime(2021, 1, 1, 0, 0, DateTimeZone.UTC);
        LimitChronology baseChronology = LimitChronology.getInstance(GregorianChronology.getInstance(DateTimeZone.UTC), lowerLimit, upperLimit); // Use LimitChronology with GregorianChronology

        // Act
        LimitChronology result = null;
        try {
            result = (LimitChronology) baseChronology.withZone(zone);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertNotNull(result);
        assertNotSame(baseChronology, result);
    }

    @Test(timeout = 4000)
    public void testWithZone_SameZone() {
        // Arrange
        DateTimeZone zone = DateTimeZone.UTC; // Testing with the same zone
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0, DateTimeZone.UTC);
        DateTime upperLimit = new DateTime(2021, 1, 1, 0, 0, DateTimeZone.UTC);
        LimitChronology baseChronology = LimitChronology.getInstance(GregorianChronology.getInstance(DateTimeZone.UTC), lowerLimit, upperLimit); // Use LimitChronology with GregorianChronology

        // Act
        LimitChronology result = null;
        try {
            result = (LimitChronology) baseChronology.withZone(zone);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertSame(baseChronology, result);
    }


}