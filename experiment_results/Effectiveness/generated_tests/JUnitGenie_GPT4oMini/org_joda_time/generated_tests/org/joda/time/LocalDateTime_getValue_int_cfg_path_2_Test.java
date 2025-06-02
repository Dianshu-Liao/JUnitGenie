package org.joda.time;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalDateTime_getValue_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetValueYear() {
        LocalDateTime localDateTime = new LocalDateTime();
        int result = localDateTime.getValue(0); // YEAR
        assertEquals("Expected year value", localDateTime.getChronology().year().get(localDateTime.getLocalMillis()), result);
    }

    @Test(timeout = 4000)
    public void testGetValueMonthOfYear() {
        LocalDateTime localDateTime = new LocalDateTime();
        int result = localDateTime.getValue(1); // MONTH_OF_YEAR
        assertEquals("Expected month value", localDateTime.getChronology().monthOfYear().get(localDateTime.getLocalMillis()), result);
    }

    @Test(timeout = 4000)
    public void testGetValueDayOfMonth() {
        LocalDateTime localDateTime = new LocalDateTime();
        int result = localDateTime.getValue(2); // DAY_OF_MONTH
        assertEquals("Expected day value", localDateTime.getChronology().dayOfMonth().get(localDateTime.getLocalMillis()), result);
    }

    @Test(timeout = 4000)
    public void testGetValueMillisOfDay() {
        LocalDateTime localDateTime = new LocalDateTime();
        int result = localDateTime.getValue(3); // MILLIS_OF_DAY
        assertEquals("Expected millis value", localDateTime.getChronology().millisOfDay().get(localDateTime.getLocalMillis()), result);
    }

    @Test(timeout = 4000)
    public void testGetValueInvalidIndex() {
        LocalDateTime localDateTime = new LocalDateTime();
        try {
            localDateTime.getValue(4); // Invalid index
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Invalid index: 4", e.getMessage());
        }
    }

}