package org.joda.time;
import org.joda.time.MonthDay;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

public class MonthDay_fromDateFields_Date_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFromDateFields_ValidDate() {
        // Arrange
        Date date = new Date(2023 - 1900, 10 - 1, 15); // October 15, 2023

        // Act
        MonthDay monthDay = null;
        try {
            monthDay = MonthDay.fromDateFields(date);
        } catch (Exception e) {
            fail("Exception should not have been thrown for a valid date");
        }

        // Assert
        assertNotNull(monthDay);
        assertEquals(10, monthDay.getMonthOfYear()); // October
        assertEquals(15, monthDay.getDayOfMonth()); // 15th
    }

    @Test(timeout = 4000)
    public void testFromDateFields_NullDate() {
        // Arrange
        Date date = null;

        // Act
        try {
            MonthDay.fromDateFields(date);
            fail("Expected IllegalArgumentException for null date");
        } catch (IllegalArgumentException e) {
            // Assert
            assertEquals("The date must not be null", e.getMessage());
        } catch (Exception e) {
            fail("Expected IllegalArgumentException but got a different exception");
        }
    }


}