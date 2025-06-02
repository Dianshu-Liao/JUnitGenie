package org.joda.time;
import org.joda.time.DateTime;
import org.joda.time.DurationField;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_plusHours_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusHours() {
        // Arrange
        DateTime dateTime = new DateTime(2023, 10, 1, 10, 0); // Initial DateTime
        int hoursToAdd = 5; // Number of hours to add

        // Act
        DateTime result = dateTime.plusHours(hoursToAdd);

        // Assert
        DateTime expectedDateTime = new DateTime(2023, 10, 1, 15, 0); // Expected DateTime after adding hours
        assertEquals(expectedDateTime, result);
    }

    @Test(timeout = 4000)
    public void testPlusHoursWithZero() {
        // Arrange
        DateTime dateTime = new DateTime(2023, 10, 1, 10, 0); // Initial DateTime
        int hoursToAdd = 0; // Number of hours to add

        // Act
        DateTime result = dateTime.plusHours(hoursToAdd);

        // Assert
        assertEquals(dateTime, result); // Should return the same DateTime
    }

    @Test(timeout = 4000)
    public void testPlusHoursNegative() {
        // Arrange
        DateTime dateTime = new DateTime(2023, 10, 1, 10, 0); // Initial DateTime
        int hoursToAdd = -3; // Number of hours to add

        // Act
        DateTime result = dateTime.plusHours(hoursToAdd);

        // Assert
        DateTime expectedDateTime = new DateTime(2023, 10, 1, 7, 0); // Expected DateTime after adding negative hours
        assertEquals(expectedDateTime, result);
    }

}