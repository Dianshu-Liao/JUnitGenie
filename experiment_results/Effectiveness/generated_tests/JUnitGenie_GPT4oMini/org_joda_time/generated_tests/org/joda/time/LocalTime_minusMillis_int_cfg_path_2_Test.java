package org.joda.time;
import org.joda.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalTime_minusMillis_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMinusMillisWithZero() {
        LocalTime localTime = new LocalTime(10, 30); // Example instantiation
        LocalTime result = localTime.minusMillis(0);
        assertEquals(localTime, result);
    }

}