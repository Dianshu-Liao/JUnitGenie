package org.joda.time;
import org.joda.time.Seconds;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Seconds_seconds_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSecondsWithTwo() {
        try {
            Seconds result = Seconds.seconds(2);
            assertEquals(Seconds.TWO, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}