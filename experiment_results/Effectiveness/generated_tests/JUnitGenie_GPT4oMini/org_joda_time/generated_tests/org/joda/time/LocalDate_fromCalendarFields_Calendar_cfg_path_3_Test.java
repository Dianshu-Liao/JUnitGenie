package org.joda.time;
import org.joda.time.LocalDate;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;

public class LocalDate_fromCalendarFields_Calendar_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testFromCalendarFields_ValidCalendar() {
        Calendar calendar = new GregorianCalendar(2023, Calendar.MARCH, 15);
        LocalDate result = null;
        try {
            result = LocalDate.fromCalendarFields(calendar);
        } catch (Exception e) {
            fail("Expected no exception to be thrown, but got: " + e.getMessage());
        }
        assertNotNull(result);
        assertEquals(2023, result.getYear());
        assertEquals(3, result.getMonthOfYear());
        assertEquals(15, result.getDayOfMonth());
    }

    @Test(timeout = 4000)
    public void testFromCalendarFields_NullCalendar() {
        Calendar calendar = null;
        try {
            LocalDate.fromCalendarFields(calendar);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("The calendar must not be null", e.getMessage());
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got: " + e.getClass().getName());
        }
    }

    @Test(timeout = 4000)
    public void testFromCalendarFields_AdjustedYear() {
        Calendar calendar = new GregorianCalendar(2023, Calendar.MARCH, 15);
        LocalDate result = null;
        try {
            result = LocalDate.fromCalendarFields(calendar);
        } catch (Exception e) {
            fail("Expected no exception to be thrown, but got: " + e.getMessage());
        }
        assertNotNull(result);
        assertEquals(2023, result.getYear());
    }

    @Test(timeout = 4000)
    public void testFromCalendarFields_LeapYear() {
        Calendar calendar = new GregorianCalendar(2020, Calendar.FEBRUARY, 29);
        LocalDate result = null;
        try {
            result = LocalDate.fromCalendarFields(calendar);
        } catch (Exception e) {
            fail("Expected no exception to be thrown, but got: " + e.getMessage());
        }
        assertNotNull(result);
        assertEquals(2020, result.getYear());
        assertEquals(2, result.getMonthOfYear());
        assertEquals(29, result.getDayOfMonth());
    }

    @Test(timeout = 4000)
    public void testFromCalendarFields_InvalidDay() {
        Calendar calendar = new GregorianCalendar(2023, Calendar.FEBRUARY, 30); // Invalid day
        try {
            LocalDate.fromCalendarFields(calendar);
            fail("Expected an exception due to invalid day");
        } catch (Exception e) {
            // Expected an exception to be thrown
        }
    }

}