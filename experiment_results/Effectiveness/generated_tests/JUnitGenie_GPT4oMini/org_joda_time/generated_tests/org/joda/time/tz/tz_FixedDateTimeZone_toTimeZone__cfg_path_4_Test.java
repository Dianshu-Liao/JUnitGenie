package org.joda.time.tz;
import org.joda.time.tz.FixedDateTimeZone;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class tz_FixedDateTimeZone_toTimeZone__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testToTimeZoneWithStandardFormat() {
        // Arrange
        FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone("TestZone", "+05:00", 5 * 60 * 60 * 1000, 0);
        
        // Act
        java.util.TimeZone result = fixedDateTimeZone.toTimeZone();
        
        // Assert
        assertEquals("GMT+05:00", result.getID());
    }

    @Test(timeout = 4000)
    public void testToTimeZoneWithUnusualOffset() {
        // Arrange
        FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone("TestZone", "TestID", 0, 0);
        
        // Act
        java.util.TimeZone result = fixedDateTimeZone.toTimeZone();
        
        // Assert
        assertEquals("TestID", result.getID());
    }

}