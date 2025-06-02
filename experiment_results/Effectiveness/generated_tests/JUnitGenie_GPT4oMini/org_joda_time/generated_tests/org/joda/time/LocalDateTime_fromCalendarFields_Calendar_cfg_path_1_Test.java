package org.joda.time;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.fail;

public class LocalDateTime_fromCalendarFields_Calendar_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFromCalendarFields_NullCalendar() {
        try {
            LocalDateTime result = LocalDateTime.fromCalendarFields(null);
            fail("Expected IllegalArgumentException for null calendar");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

}