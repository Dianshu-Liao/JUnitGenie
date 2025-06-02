package org.joda.time;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_minusMinutes_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMinusMinutesWithZero() {
        DateTime dateTime = new DateTime(); // Instantiate DateTime
        DateTime result = dateTime.minusMinutes(0); // Call the focal method with 0 minutes

        // Assert that the result is the same as the original DateTime
        assertEquals(dateTime, result);
    }

}