package org.joda.time;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalDateTime_minusSeconds_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMinusSeconds_NonZeroSeconds() {
        LocalDateTime dateTime = new LocalDateTime(2023, 10, 1, 12, 0);
        LocalDateTime result = dateTime.minusSeconds(10);
        LocalDateTime expected = new LocalDateTime(2023, 10, 1, 11, 59, 50);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testMinusSeconds_ZeroSeconds() {
        LocalDateTime dateTime = new LocalDateTime(2023, 10, 1, 12, 0);
        LocalDateTime result = dateTime.minusSeconds(0);
        assertEquals(dateTime, result);
    }

    @Test(timeout = 4000)
    public void testMinusSeconds_NegativeSeconds() {
        LocalDateTime dateTime = new LocalDateTime(2023, 10, 1, 12, 0);
        LocalDateTime result = dateTime.minusSeconds(-10);
        LocalDateTime expected = new LocalDateTime(2023, 10, 1, 12, 0).plusSeconds(10);
        assertEquals(expected, result);
    }

}