package org.joda.time;
import org.joda.time.YearMonth;
import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.fail;

public class YearMonth_fromCalendarFields_Calendar_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFromCalendarFields_NullCalendar() {
        try {
            YearMonth result = YearMonth.fromCalendarFields(null);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("The calendar must not be null");
        }
    }

}