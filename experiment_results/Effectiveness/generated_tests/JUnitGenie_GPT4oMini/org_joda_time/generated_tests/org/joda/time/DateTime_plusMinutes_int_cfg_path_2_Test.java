package org.joda.time;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_plusMinutes_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPlusMinutesWithZero() {
        DateTime dateTime = new DateTime(); // Using the default constructor
        DateTime result = dateTime.plusMinutes(0);
        
        // Since adding 0 minutes should return the same instance
        assertEquals(dateTime, result);
    }

}