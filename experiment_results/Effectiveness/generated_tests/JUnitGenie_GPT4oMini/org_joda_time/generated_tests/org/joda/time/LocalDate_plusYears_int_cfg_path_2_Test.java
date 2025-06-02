package org.joda.time;
import org.joda.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalDate_plusYears_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPlusYearsWithZero() {
        LocalDate date = new LocalDate(2020, 1, 1);
        LocalDate result = date.plusYears(0);
        assertEquals(date, result);
    }

    @Test(timeout = 4000)
    public void testPlusYearsWithPositiveValue() {
        LocalDate date = new LocalDate(2020, 1, 1);
        LocalDate result = date.plusYears(5);
        LocalDate expected = new LocalDate(2025, 1, 1);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testPlusYearsWithNegativeValue() {
        LocalDate date = new LocalDate(2020, 1, 1);
        LocalDate result = date.plusYears(-3);
        LocalDate expected = new LocalDate(2017, 1, 1);
        assertEquals(expected, result);
    }

}