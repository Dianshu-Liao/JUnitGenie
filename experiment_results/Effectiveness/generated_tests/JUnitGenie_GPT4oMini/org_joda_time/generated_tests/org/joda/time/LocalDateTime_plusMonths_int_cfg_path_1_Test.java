package org.joda.time;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalDateTime_plusMonths_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusMonths_NonZeroMonths() {
        LocalDateTime originalDateTime = new LocalDateTime(2021, 1, 1, 0, 0);
        LocalDateTime expectedDateTime = new LocalDateTime(2021, 3, 1, 0, 0); // Adding 2 months to January 1, 2021
        
        LocalDateTime resultDateTime = originalDateTime.plusMonths(2);
        assertEquals(expectedDateTime, resultDateTime);
    }

    @Test(timeout = 4000)
    public void testPlusMonths_ZeroMonths() {
        LocalDateTime originalDateTime = new LocalDateTime(2021, 1, 1, 0, 0);
        
        LocalDateTime resultDateTime = originalDateTime.plusMonths(0);
        assertEquals(originalDateTime, resultDateTime); // Should return the same instance
    }

}