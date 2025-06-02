package org.joda.time;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class Period_plusSeconds_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusSeconds() {
        // Arrange
        Period period = new Period(0, 0, 0, 0); // Initializing a Period object
        int secondsToAdd = 5; // Test input for seconds

        // Act
        Period result = null;
        try {
            result = period.plusSeconds(secondsToAdd);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        assertNotNull(result); // Ensure the result is not null
    }

}