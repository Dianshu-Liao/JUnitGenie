package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.assertNotNull;

public class time_DateUtils_round_Object_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRoundWithCalendar() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 10, 12, 30, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        int field = Calendar.HOUR; // Field to round to

        // Act
        Date result = null;
        try {
            result = DateUtils.round(calendar.getTime(), field); // Convert Calendar to Date
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testRoundWithDate() {
        // Arrange
        Date date = new Date();
        int field = Calendar.HOUR; // Field to round to

        // Act
        Date result = null;
        try {
            result = DateUtils.round(date, field);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
    }

    @Test(expected = ClassCastException.class)
    public void testRoundWithInvalidType() {
        // Arrange
        Object invalidDate = "Not a date or calendar";
        int field = Calendar.HOUR; // Field to round to

        // Act
        try {
            DateUtils.round(invalidDate, field);
        } catch (ClassCastException e) {
            // Exception is expected
            throw e; // Rethrow to satisfy the expected exception
        }
    }


}