package org.joda.time;
import org.joda.time.Interval;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Interval_withStartMillis_long_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithStartMillis() {
        // Arrange
        long startMillis = 1000L;
        long endMillis = 2000L;
        Chronology chronology = null; // Assuming default chronology for simplicity
        Interval interval = new Interval(startMillis, endMillis, chronology);

        // Act
        Interval result = interval.withStartMillis(1500L);

        // Assert
        assertEquals(1500L, result.getStartMillis());
        assertEquals(endMillis, result.getEndMillis());
    }

    @Test(timeout = 4000)
    public void testWithStartMillisSameValue() {
        // Arrange
        long startMillis = 1000L;
        long endMillis = 2000L;
        Chronology chronology = null; // Assuming default chronology for simplicity
        Interval interval = new Interval(startMillis, endMillis, chronology);

        // Act
        Interval result = interval.withStartMillis(startMillis);

        // Assert
        assertEquals(interval, result); // Should return the same instance
    }

}