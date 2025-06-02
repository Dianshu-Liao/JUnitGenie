package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Chronology;
import org.joda.time.chrono.LimitChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_LimitChronology_withZone_DateTimeZone_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testWithZone() {
        // Arrange
        DateTimeZone zone = DateTimeZone.getDefault(); // Ensure zone is non-null and valid
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0, zone);
        DateTime upperLimit = new DateTime(2021, 1, 1, 0, 0, zone);
        
        // Using LimitChronology.create method to create an instance
        LimitChronology chronology = LimitChronology.getInstance(null, lowerLimit, upperLimit);

        // Act
        Chronology result = null;
        try {
            result = chronology.withZone(zone);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertNotNull(result);
        assertTrue(result instanceof LimitChronology);
    }


}