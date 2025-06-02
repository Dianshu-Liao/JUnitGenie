package org.joda.time;
import org.joda.time.LocalDate;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalDate_plusYears_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusYears_nonZeroYears() {
        LocalDate initialDate = new LocalDate(2020, 1, 1); // Initial date: January 1, 2020
        LocalDate expectedDate = new LocalDate(2025, 1, 1); // Expecting the date after adding 5 years

        LocalDate resultDate = initialDate.plusYears(5); // Add 5 years
        assertEquals(expectedDate, resultDate); // Assert that the result is as expected
    }

    @Test(timeout = 4000)
    public void testPlusYears_zeroYears() {
        LocalDate initialDate = new LocalDate(2020, 1, 1); // Initial date: January 1, 2020

        LocalDate resultDate = initialDate.plusYears(0); // Add 0 years
        assertEquals(initialDate, resultDate); // Assert that the result is the same as initial date
    }

}