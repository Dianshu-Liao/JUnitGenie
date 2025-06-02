package org.joda.time;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalDateTime_minusSeconds_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMinusSeconds_WithZeroSeconds() {
        LocalDateTime initialDateTime = new LocalDateTime(2023, 10, 1, 12, 0);
        LocalDateTime result = initialDateTime.minusSeconds(0);
        assertEquals(initialDateTime, result);
    }

}