package org.joda.time;
import org.joda.time.Seconds;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Seconds_seconds_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSecondsWithThree() {
        try {
            Seconds result = Seconds.seconds(3);
            assertEquals(Seconds.THREE, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}