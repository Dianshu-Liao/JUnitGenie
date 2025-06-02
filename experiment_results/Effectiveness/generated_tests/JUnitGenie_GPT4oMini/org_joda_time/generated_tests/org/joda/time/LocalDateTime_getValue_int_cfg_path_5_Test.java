package org.joda.time;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalDateTime_getValue_int_cfg_path_5_Test {

    private static final int YEAR = 0;
    private static final int MONTH_OF_YEAR = 1;
    private static final int DAY_OF_MONTH = 2;
    private static final int MILLIS_OF_DAY = 3;

    @Test(timeout = 4000)
    public void testGetValueYear() {
        LocalDateTime localDateTime = new LocalDateTime();
        int result = localDateTime.getValue(YEAR);
        assertEquals(localDateTime.getChronology().year().get(localDateTime.getLocalMillis()), result);
    }

    @Test(timeout = 4000)
    public void testGetValueMonthOfYear() {
        LocalDateTime localDateTime = new LocalDateTime();
        int result = localDateTime.getValue(MONTH_OF_YEAR);
        assertEquals(localDateTime.getChronology().monthOfYear().get(localDateTime.getLocalMillis()), result);
    }

    @Test(timeout = 4000)
    public void testGetValueDayOfMonth() {
        LocalDateTime localDateTime = new LocalDateTime();
        int result = localDateTime.getValue(DAY_OF_MONTH);
        assertEquals(localDateTime.getChronology().dayOfMonth().get(localDateTime.getLocalMillis()), result);
    }

    @Test(timeout = 4000)
    public void testGetValueMillisOfDay() {
        LocalDateTime localDateTime = new LocalDateTime();
        int result = localDateTime.getValue(MILLIS_OF_DAY);
        assertEquals(localDateTime.getChronology().millisOfDay().get(localDateTime.getLocalMillis()), result);
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