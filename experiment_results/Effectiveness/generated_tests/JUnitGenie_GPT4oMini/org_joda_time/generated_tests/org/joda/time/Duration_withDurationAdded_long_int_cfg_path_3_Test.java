package org.joda.time;
import org.joda.time.Duration;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Duration_withDurationAdded_long_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWithDurationAdded_ZeroDurationToAdd() {
        Duration duration = new Duration(1000); // Create Duration instance with 1000 millis
        Duration result = duration.withDurationAdded(0, 5); // Test with durationToAdd as 0
        
        // Assert that the result is the same as the original duration
        assertEquals(duration, result);
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_ZeroScalar() {
        Duration duration = new Duration(1000); // Create Duration instance with 1000 millis
        Duration result = duration.withDurationAdded(5, 0); // Test with scalar as 0

        // Assert that the result is the same as the original duration
        assertEquals(duration, result);
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_NonZeroDurationAndScalar() {
        Duration duration = new Duration(1000); // Create Duration instance with 1000 millis
        Duration result = duration.withDurationAdded(5, 3); // Scalar is 3 and durationToAdd is 5
        
        // Calculate expected duration (1000 + (5 * 3) = 1015)
        Duration expected = new Duration(1015);

        // Assert that the result matches the expected value
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_NegativeDurationAndScalar() {
        Duration duration = new Duration(1000); // Create Duration instance
        Duration result = duration.withDurationAdded(-5, 2); // Test with negative durationToAdd
        
        // Calculate expected duration (1000 - (5 * 2) = 990)
        Duration expected = new Duration(990);

        // Assert that the result matches the expected value
        assertEquals(expected, result);
    }

}