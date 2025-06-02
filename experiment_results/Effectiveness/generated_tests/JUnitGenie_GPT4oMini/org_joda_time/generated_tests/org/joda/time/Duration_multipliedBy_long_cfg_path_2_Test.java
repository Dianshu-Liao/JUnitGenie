package org.joda.time;
import org.joda.time.Duration;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Duration_multipliedBy_long_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMultipliedBy_WhenMultiplicandIsOne_ShouldReturnSameInstance() {
        Duration duration = new Duration(1000); // Create a Duration instance with 1000 milliseconds
        Duration result = duration.multipliedBy(1);
        assertEquals(duration, result); // Assert that the result is the same instance
    }

    @Test(timeout = 4000)
    public void testMultipliedBy_WhenMultiplicandIsNotOne_ShouldReturnNewInstance() {
        Duration duration = new Duration(1000); // Create a Duration instance with 1000 milliseconds
        Duration result = duration.multipliedBy(2);
        assertEquals(new Duration(2000), result); // Assert that the result is a new Duration instance with 2000 milliseconds
    }

}