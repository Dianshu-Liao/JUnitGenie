package org.joda.time;
import org.joda.time.LocalDate;
import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

public class LocalDate_fromCalendarFields_Calendar_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFromCalendarFields_NullCalendar() {
        try {
            LocalDate result = LocalDate.fromCalendarFields(null);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertEquals("The calendar must not be null", e.getMessage());
        }
    }


}