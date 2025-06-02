package org.joda.time;
import org.joda.time.Weeks;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Weeks_weeks_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWeeks_WithThree() {
        try {
            // Arrange
            int inputWeeks = 3;

            // Act
            Weeks result = Weeks.weeks(inputWeeks);

            // Assert
            assertEquals(Weeks.THREE, result);
        } catch (Exception e) {
            // Handle the exception in case of unexpected issue
            e.printStackTrace();
        }
    }

}