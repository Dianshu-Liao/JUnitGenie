package org.joda.time;
import org.joda.time.Interval;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Interval_withStartMillis_long_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithStartMillis_SameStartMillis() {
        // Arrange
        long startMillis = 1000L;
        Interval interval = new Interval(startMillis, 2000L);
        
        // Act
        Interval result = interval.withStartMillis(startMillis);
        
        // Assert
        assertEquals(interval, result);
    }

    @Test(timeout = 4000)
    public void testWithStartMillis_DifferentStartMillis() {
        // Arrange
        long startMillis = 1000L;
        long newStartMillis = 1500L;
        Interval interval = new Interval(startMillis, 2000L);
        
        // Act
        Interval result = interval.withStartMillis(newStartMillis);
        
        // Assert
        assertEquals(newStartMillis, result.getStartMillis());
        assertEquals(2000L, result.getEndMillis());
    }

}