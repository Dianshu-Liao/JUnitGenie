package org.joda.time;
import org.joda.time.Seconds;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Seconds_seconds_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSecondsMaxValue() {
        try {
            Seconds result = Seconds.seconds(Integer.MAX_VALUE);
            assertEquals(Seconds.MAX_VALUE, result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}