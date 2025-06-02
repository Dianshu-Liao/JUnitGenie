package org.joda.time;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_plusHours_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPlusHoursWithZero() {
        DateTime dateTime = new DateTime(); // Using the default constructor
        DateTime result = dateTime.plusHours(0);
        assertEquals(dateTime, result); // Expecting the same instance when adding zero hours
    }

}