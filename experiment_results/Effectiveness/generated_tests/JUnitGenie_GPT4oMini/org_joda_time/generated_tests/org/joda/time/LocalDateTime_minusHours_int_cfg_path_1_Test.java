package org.joda.time;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalDateTime_minusHours_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMinusHours() {
        LocalDateTime dateTime = new LocalDateTime(2023, 10, 1, 12, 0); // Initial date and time
        LocalDateTime expectedDateTime = new LocalDateTime(2023, 10, 1, 11, 0); // Expected result after subtracting 1 hour

        LocalDateTime result = dateTime.minusHours(1); // Call the focal method

        assertEquals(expectedDateTime, result); // Verify the result
    }

    @Test(timeout = 4000)
    public void testMinusHoursWithZero() {
        LocalDateTime dateTime = new LocalDateTime(2023, 10, 1, 12, 0); // Initial date and time

        LocalDateTime result = dateTime.minusHours(0); // Call the focal method with 0 hours

        assertEquals(dateTime, result); // Verify that the result is the same as the original
    }

}