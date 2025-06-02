package org.joda.time;
import org.joda.time.MonthDay;
import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.*;

public class MonthDay_fromCalendarFields_Calendar_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFromCalendarFields_ValidInput() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 15); // January 15, 2023
        MonthDay monthDay = MonthDay.fromCalendarFields(calendar);
        assertEquals(1, monthDay.getMonthOfYear()); // Month should be January (1)
        assertEquals(15, monthDay.getDayOfMonth()); // Day should be 15
    }

    @Test(timeout = 4000)
    public void testFromCalendarFields_NullCalendar() {
        try {
            MonthDay.fromCalendarFields(null);
            fail("Expected IllegalArgumentException for null calendar");
        } catch (IllegalArgumentException e) {
            assertEquals("The calendar must not be null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFromCalendarFields_FebruaryLeapYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.FEBRUARY, 29); // February 29, 2020 (leap year)
        MonthDay monthDay = MonthDay.fromCalendarFields(calendar);
        assertEquals(2, monthDay.getMonthOfYear()); // Month should be February (2)
        assertEquals(29, monthDay.getDayOfMonth()); // Day should be 29
    }

    @Test(timeout = 4000)
    public void testFromCalendarFields_FebruaryNonLeapYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.FEBRUARY, 28); // February 28, 2021 (non-leap year)
        MonthDay monthDay = MonthDay.fromCalendarFields(calendar);
        assertEquals(2, monthDay.getMonthOfYear()); // Month should be February (2)
        assertEquals(28, monthDay.getDayOfMonth()); // Day should be 28
    }

    @Test(timeout = 4000)
    public void testFromCalendarFields_InvalidDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.APRIL, 31); // April 31, 2023 (invalid)
        try {
            MonthDay monthDay = MonthDay.fromCalendarFields(calendar);
            fail("Expected IllegalArgumentException for invalid day");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }


}