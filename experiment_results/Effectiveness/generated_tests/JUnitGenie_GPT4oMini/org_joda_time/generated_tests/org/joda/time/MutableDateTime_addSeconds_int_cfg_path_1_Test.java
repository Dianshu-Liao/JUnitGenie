package org.joda.time;
import org.joda.time.MutableDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class MutableDateTime_addSeconds_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddSeconds_NonZeroSeconds() {
        MutableDateTime dateTime = new MutableDateTime();
        long initialMillis = dateTime.getMillis();
        int secondsToAdd = 10;

        dateTime.addSeconds(secondsToAdd);
        
        // Verify that the milliseconds have been updated correctly
        long expectedMillis = dateTime.getChronology().seconds().add(initialMillis, secondsToAdd);
        assertEquals(expectedMillis, dateTime.getMillis());
    }

    @Test(timeout = 4000)
    public void testAddSeconds_ZeroSeconds() {
        MutableDateTime dateTime = new MutableDateTime();
        long initialMillis = dateTime.getMillis();
        int secondsToAdd = 0;

        dateTime.addSeconds(secondsToAdd);
        
        // Verify that the milliseconds remain unchanged
        assertEquals(initialMillis, dateTime.getMillis());
    }

}