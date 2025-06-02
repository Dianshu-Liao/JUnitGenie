package org.joda.time;
import org.joda.time.TimeOfDay;
import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

public class TimeOfDay_fromCalendarFields_Calendar_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFromCalendarFields_NullCalendar() {
        try {
            TimeOfDay.fromCalendarFields(null);
            fail("Expected IllegalArgumentException for null calendar");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertEquals("The calendar must not be null", e.getMessage());
        }
    }


}