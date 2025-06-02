package org.joda.time;
import org.joda.time.Duration;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Duration_withDurationAdded_long_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithDurationAdded_NonZeroDurationAndScalar() {
        Duration duration = new Duration(1000); // Initial duration of 1000 milliseconds
        Duration result = duration.withDurationAdded(500, 2); // Adding 500 milliseconds with a scalar of 2
        assertEquals(new Duration(2000), result); // Expecting the result to be 2000 milliseconds
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_ZeroDuration() {
        Duration duration = new Duration(1000); // Initial duration of 1000 milliseconds
        Duration result = duration.withDurationAdded(0, 2); // Adding 0 milliseconds
        assertEquals(duration, result); // Expecting the result to be the same as the initial duration
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_ZeroScalar() {
        Duration duration = new Duration(1000); // Initial duration of 1000 milliseconds
        Duration result = duration.withDurationAdded(500, 0); // Adding 500 milliseconds with a scalar of 0
        assertEquals(duration, result); // Expecting the result to be the same as the initial duration
    }

}