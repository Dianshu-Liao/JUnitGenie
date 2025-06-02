package org.joda.time;
import org.joda.time.YearMonth;
import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.*;

public class YearMonth_fromCalendarFields_Calendar_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFromCalendarFields_ValidCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.MARCH, 1); // Set to March 1, 2023

        YearMonth yearMonth = YearMonth.fromCalendarFields(calendar);
        assertEquals(2023, yearMonth.getYear());
        assertEquals(2, yearMonth.getMonthOfYear()); // Corrected to getMonthOfYear() and adjusted to 1-based
    }

    @Test(timeout = 4000)
    public void testFromCalendarFields_NullCalendar() {
        try {
            YearMonth.fromCalendarFields(null);
            fail("Expected IllegalArgumentException for null calendar");
        } catch (IllegalArgumentException e) {
            assertEquals("The calendar must not be null", e.getMessage());
        }
    }


}