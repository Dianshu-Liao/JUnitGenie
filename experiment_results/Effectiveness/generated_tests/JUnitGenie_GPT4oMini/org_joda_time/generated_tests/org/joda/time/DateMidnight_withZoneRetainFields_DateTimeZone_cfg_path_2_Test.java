package org.joda.time;
import org.joda.time.DateMidnight;
import org.joda.time.DateTimeZone;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateMidnight_withZoneRetainFields_DateTimeZone_cfg_path_2_Test {

    // Test method for withZoneRetainFields
    @Test(timeout = 4000)
    public void testWithZoneRetainFieldsSameZone() {
        // Arrange
        DateMidnight dateMidnight = new DateMidnight(); // Using the default constructor
        DateTimeZone defaultZone = DateTimeZone.getDefault();
        
        DateTimeZone nullZone = null; // Prepare the null zone for the test

        // Act
        DateMidnight result = dateMidnight.withZoneRetainFields(nullZone);

        // Assert
        assertSame(dateMidnight, result); // Since the zones are the same, it should return 'this'
    }

}