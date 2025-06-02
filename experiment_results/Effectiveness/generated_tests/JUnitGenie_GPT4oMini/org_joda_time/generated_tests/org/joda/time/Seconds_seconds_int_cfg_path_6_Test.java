package org.joda.time;
import org.joda.time.Seconds;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Seconds_seconds_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testSecondsWithMinValue() {
        try {
            Seconds result = Seconds.seconds(Integer.MIN_VALUE);
            assertEquals(Seconds.MIN_VALUE, result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}