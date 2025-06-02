package org.joda.time;
import org.joda.time.MutableDateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MutableDateTime_addYears_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddYears_NoChange() {
        MutableDateTime dateTime = new MutableDateTime(); // Initialize with current time
        long originalMillis = dateTime.getMillis(); // Store original milliseconds

        dateTime.addYears(0); // Call the method with years = 0

        // Assert that the milliseconds remain unchanged
        assertEquals(originalMillis, dateTime.getMillis());
    }

}