package org.joda.time;
import org.joda.time.MonthDay;
import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.*;

public class MonthDay_fromCalendarFields_Calendar_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFromCalendarFields_NullCalendar() {
        try {
            MonthDay.fromCalendarFields(null);
            fail("Expected IllegalArgumentException for null calendar");
        } catch (IllegalArgumentException e) {
            assertEquals("The calendar must not be null", e.getMessage());
        }
    }

}