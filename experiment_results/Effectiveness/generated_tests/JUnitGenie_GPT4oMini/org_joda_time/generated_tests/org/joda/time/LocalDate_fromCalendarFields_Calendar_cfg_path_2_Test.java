package org.joda.time;
import org.joda.time.LocalDate;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;

public class LocalDate_fromCalendarFields_Calendar_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFromCalendarFields_validCalendar() {
        Calendar calendar = new GregorianCalendar(2023, Calendar.JANUARY, 15);
        LocalDate result = null;
        try {
            result = LocalDate.fromCalendarFields(calendar);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid calendar: " + e.getMessage());
        }
        assertNotNull(result);
        assertEquals(2023, result.getYear());
        assertEquals(1, result.getMonthOfYear());
        assertEquals(15, result.getDayOfMonth());
    }

    @Test(timeout = 4000)
    public void testFromCalendarFields_nullCalendar() {
        try {
            LocalDate.fromCalendarFields(null);
            fail("Expected IllegalArgumentException for null calendar");
        } catch (IllegalArgumentException e) {
            assertEquals("The calendar must not be null", e.getMessage());
        } catch (Exception e) {
            fail("Expected IllegalArgumentException but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFromCalendarFields_negativeYear() {
        Calendar calendar = new GregorianCalendar(-2023, Calendar.JANUARY, 15);
        LocalDate result = null;
        try {
            result = LocalDate.fromCalendarFields(calendar);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid negative year calendar: " + e.getMessage());
        }
        assertNotNull(result);
        assertEquals(-2023, result.getYear());
        assertEquals(1, result.getMonthOfYear());
        assertEquals(15, result.getDayOfMonth());
    }

}