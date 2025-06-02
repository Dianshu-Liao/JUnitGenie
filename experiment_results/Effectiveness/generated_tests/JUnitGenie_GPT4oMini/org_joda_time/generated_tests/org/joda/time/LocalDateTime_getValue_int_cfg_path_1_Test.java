package org.joda.time;
import org.joda.time.LocalDateTime;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalDateTime_getValue_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetValueMonthOfYear() {
        LocalDateTime localDateTime = new LocalDateTime();
        int index = 1; // MONTH_OF_YEAR
        try {
            int result = localDateTime.getValue(index);
            assertTrue(result >= 1 && result <= 12); // Ensure the result is a valid month
        } catch (IndexOutOfBoundsException e) {
            fail("IndexOutOfBoundsException should not be thrown for valid index: " + index);
        }
    }

    @Test(timeout = 4000)
    public void testGetValueInvalidIndex() {
        LocalDateTime localDateTime = new LocalDateTime();
        int index = 5; // Invalid index
        try {
            localDateTime.getValue(index);
            fail("IndexOutOfBoundsException should be thrown for invalid index: " + index);
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

}