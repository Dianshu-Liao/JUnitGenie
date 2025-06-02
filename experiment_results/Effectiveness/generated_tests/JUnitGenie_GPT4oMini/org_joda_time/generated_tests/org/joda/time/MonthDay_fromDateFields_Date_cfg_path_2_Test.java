package org.joda.time;
import org.joda.time.MonthDay;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MonthDay_fromDateFields_Date_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFromDateFields_NullDate_ThrowsIllegalArgumentException() {
        try {
            MonthDay.fromDateFields(null);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertEquals("The date must not be null", e.getMessage());
        }
    }


}