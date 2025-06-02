package org.joda.time;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;

public class LocalDateTime_fromCalendarFields_Calendar_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFromCalendarFields_ValidCalendar() {
        Calendar calendar = new GregorianCalendar(2023, Calendar.JANUARY, 1, 12, 30, 45);
        LocalDateTime result = null;

        try {
            result = LocalDateTime.fromCalendarFields(calendar);
        } catch (Exception e) {
            fail("Expected no exception, but got: " + e);
        }

        assertNotNull(result);
        assertEquals(2023, result.getYear());
        assertEquals(1, result.getMonthOfYear());
        assertEquals(1, result.getDayOfMonth());
        assertEquals(12, result.getHourOfDay());
        assertEquals(30, result.getMinuteOfHour());
        assertEquals(45, result.getSecondOfMinute());
    }

    @Test(timeout = 4000)
    public void testFromCalendarFields_NullCalendar() {
        Calendar calendar = null;

        try {
            LocalDateTime result = LocalDateTime.fromCalendarFields(calendar);
            fail("Expected IllegalArgumentException due to null calendar");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got: " + e);
        }
    }

}