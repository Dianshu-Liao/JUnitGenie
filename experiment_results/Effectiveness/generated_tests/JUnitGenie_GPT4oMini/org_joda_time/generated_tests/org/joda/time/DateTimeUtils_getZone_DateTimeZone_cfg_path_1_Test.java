package org.joda.time;
import org.joda.time.DateTimeZone;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTimeUtils_getZone_DateTimeZone_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetZoneWithNull() {
        try {
            DateTimeZone result = DateTimeUtils.getZone(null);
            DateTimeZone expected = DateTimeZone.getDefault();
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}