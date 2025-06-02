package org.joda.time;
import org.joda.time.Seconds;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Seconds_seconds_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSeconds_one() {
        try {
            Seconds result = Seconds.seconds(1);
            assertEquals(Seconds.ONE, result);
        } catch (Exception e) {
            // Handle exception if needed
        }
    }

}