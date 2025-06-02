package org.joda.time;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalDateTime_minusMillis_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMinusMillisWithZero() {
        LocalDateTime localDateTime = new LocalDateTime();
        LocalDateTime result = localDateTime.minusMillis(0);
        assertEquals(localDateTime, result);
    }

}