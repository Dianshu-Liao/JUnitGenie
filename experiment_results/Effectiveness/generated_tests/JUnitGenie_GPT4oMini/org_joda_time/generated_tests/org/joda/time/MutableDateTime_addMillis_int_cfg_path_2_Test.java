package org.joda.time;
import org.joda.time.MutableDateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MutableDateTime_addMillis_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddMillisWithZero() {
        MutableDateTime dateTime = new MutableDateTime();
        long initialMillis = dateTime.getMillis();
        
        try {
            dateTime.addMillis(0);
            assertEquals(initialMillis, dateTime.getMillis());
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace();
        }
    }

}