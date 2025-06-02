package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.fail;

public class time_DateUtils_round_Object_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRoundWithInvalidDate() {
        Object invalidDate = new Object(); // An object that is neither Date nor Calendar
        int field = 0; // Example field value

        try {
            DateUtils.round(invalidDate, field);
            fail("Expected ClassCastException to be thrown");
        } catch (ClassCastException e) {
            // Expected exception
        }
    }

}