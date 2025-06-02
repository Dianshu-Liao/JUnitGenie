package org.joda.time;
import org.joda.time.MutableDateTime;
import org.junit.Test;

public class MutableDateTime_addSeconds_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddSecondsWithZero() {
        MutableDateTime dateTime = new MutableDateTime();
        try {
            dateTime.addSeconds(0);
            // If no exception is thrown, we can assert that the method executed without issues.
            // Since the method does not change the state when seconds are 0, we can check the millis remain the same.
            long initialMillis = dateTime.getMillis();
            dateTime.addSeconds(0);
            assert initialMillis == dateTime.getMillis() : "Millis should remain unchanged when adding 0 seconds.";
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}