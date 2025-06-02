package org.joda.time;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalDateTime_plusMinutes_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusMinutes_NonZeroMinutes() {
        LocalDateTime initialDateTime = new LocalDateTime(2023, 10, 1, 12, 0);
        LocalDateTime expectedDateTime = new LocalDateTime(2023, 10, 1, 12, 30);
        
        LocalDateTime resultDateTime = initialDateTime.plusMinutes(30);
        
        assertEquals(expectedDateTime, resultDateTime);
    }

    @Test(timeout = 4000)
    public void testPlusMinutes_ZeroMinutes() {
        LocalDateTime initialDateTime = new LocalDateTime(2023, 10, 1, 12, 0);
        
        LocalDateTime resultDateTime = initialDateTime.plusMinutes(0);
        
        assertEquals(initialDateTime, resultDateTime);
    }

}