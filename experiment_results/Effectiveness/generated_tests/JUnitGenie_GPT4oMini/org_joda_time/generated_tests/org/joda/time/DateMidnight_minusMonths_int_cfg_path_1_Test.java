package org.joda.time;
import org.joda.time.DateMidnight;
import org.joda.time.Chronology;
import org.joda.time.DurationField;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class DateMidnight_minusMonths_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMinusMonths() {
        try {
            // Arrange
            DateMidnight dateMidnight = new DateMidnight(); // Using default constructor
            int monthsToSubtract = 1; // Valid input for months

            // Act
            DateMidnight result = dateMidnight.minusMonths(monthsToSubtract);

            // Assert
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}