package org.joda.time;
import org.joda.time.MutableDateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MutableDateTime_addMonths_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddMonthsWithZero() {
        MutableDateTime dateTime = new MutableDateTime();
        long initialMillis = dateTime.getMillis();
        
        // Call the method with months = 0
        dateTime.addMonths(0);
        
        // Assert that the millis remain unchanged
        assertEquals(initialMillis, dateTime.getMillis());
    }

}