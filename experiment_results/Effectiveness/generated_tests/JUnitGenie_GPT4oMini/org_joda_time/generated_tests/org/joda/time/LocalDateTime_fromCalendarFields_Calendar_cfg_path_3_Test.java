package org.joda.time;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;

public class LocalDateTime_fromCalendarFields_Calendar_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testFromCalendarFields_ValidCalendar() {
        Calendar calendar = new GregorianCalendar(2021, Calendar.JANUARY, 15, 10, 30, 45);
        LocalDateTime result = null;
        try {
            result = LocalDateTime.fromCalendarFields(calendar);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid calendar: " + e.getMessage());
        }
        
        assertNotNull(result);
        assertEquals(2021, result.getYear());
        assertEquals(1, result.getMonthOfYear());
        assertEquals(15, result.getDayOfMonth());
        assertEquals(10, result.getHourOfDay());
        assertEquals(30, result.getMinuteOfHour());
        assertEquals(45, result.getSecondOfMinute());
    }

    @Test(timeout = 4000)
    public void testFromCalendarFields_NullCalendar() {
        Calendar calendar = null;
        try {
            LocalDateTime.fromCalendarFields(calendar);
            fail("Expected IllegalArgumentException for null calendar");
        } catch (IllegalArgumentException e) {
            assertEquals("The calendar must not be null", e.getMessage());
        } catch (Exception e) {
            fail("Expected IllegalArgumentException but got: " + e.getMessage());
        }
    }

}