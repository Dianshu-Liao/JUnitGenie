package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.assertNotNull;

public class time_DateUtils_round_Object_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRoundWithDate() {
        try {
            // Given
            Date date = new Date();
            int field = Calendar.YEAR; // Valid field for rounding

            // When
            Date roundedDate = DateUtils.round(date, field);

            // Then
            assertNotNull(roundedDate);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

}