package org.joda.time;
import org.joda.time.LocalDate;
import org.joda.time.Chronology;
import org.joda.time.DurationField;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalDate_plusDays_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusDays_NonZeroDays() {
        LocalDate date = new LocalDate(2023, 10, 1); // Create a valid LocalDate instance
        LocalDate expectedDate = new LocalDate(2023, 10, 6); // Expected date after adding 5 days
        LocalDate resultDate = date.plusDays(5); // Call the focal method with a non-zero value
        assertEquals(expectedDate, resultDate); // Assert that the result is as expected
    }

    @Test(timeout = 4000)
    public void testPlusDays_ZeroDays() {
        LocalDate date = new LocalDate(2023, 10, 1); // Create a valid LocalDate instance
        LocalDate resultDate = date.plusDays(0); // Call the focal method with zero
        assertEquals(date, resultDate); // Assert that the result is the same as the original date
    }

    @Test(timeout = 4000)
    public void testPlusDays_NegativeDays() {
        LocalDate date = new LocalDate(2023, 10, 1); // Create a valid LocalDate instance
        LocalDate expectedDate = new LocalDate(2023, 9, 26); // Expected date after subtracting 5 days
        LocalDate resultDate = date.plusDays(-5); // Call the focal method with a negative value
        assertEquals(expectedDate, resultDate); // Assert that the result is as expected
    }

}