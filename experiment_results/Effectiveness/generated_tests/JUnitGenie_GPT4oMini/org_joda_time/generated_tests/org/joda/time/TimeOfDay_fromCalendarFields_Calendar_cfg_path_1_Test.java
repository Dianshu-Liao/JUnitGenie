package org.joda.time;
import org.joda.time.TimeOfDay;
import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.*;

public class TimeOfDay_fromCalendarFields_Calendar_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFromCalendarFields_ValidCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 45);
        calendar.set(Calendar.MILLISECOND, 500);

        TimeOfDay timeOfDay = null;
        try {
            timeOfDay = TimeOfDay.fromCalendarFields(calendar);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid calendar: " + e.getMessage());
        }

        assertNotNull(timeOfDay);
        assertEquals(10, timeOfDay.getHourOfDay());
        assertEquals(30, timeOfDay.getMinuteOfHour());
        assertEquals(45, timeOfDay.getSecondOfMinute());
        assertEquals(500, timeOfDay.getMillisOfSecond());
    }

    @Test(timeout = 4000)
    public void testFromCalendarFields_NullCalendar() {
        Calendar calendar = null;

        try {
            TimeOfDay.fromCalendarFields(calendar);
            fail("Expected IllegalArgumentException for null calendar");
        } catch (IllegalArgumentException e) {
            assertEquals("The calendar must not be null", e.getMessage());
        } catch (Exception e) {
            fail("Expected IllegalArgumentException but got: " + e.getMessage());
        }
    }

}