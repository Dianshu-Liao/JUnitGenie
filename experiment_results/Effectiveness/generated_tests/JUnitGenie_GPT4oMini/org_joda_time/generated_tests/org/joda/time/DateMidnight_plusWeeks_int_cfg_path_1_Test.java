package org.joda.time;
import org.joda.time.DateMidnight;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateMidnight_plusWeeks_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusWeeks_NonZeroWeeks() {
        DateMidnight dateMidnight = new DateMidnight(2023, 10, 1); // Example date
        DateMidnight expectedDate = new DateMidnight(2023, 10, 8); // Expected date after adding 1 week
        DateMidnight result = dateMidnight.plusWeeks(1);
        assertEquals(expectedDate, result);
    }

    @Test(timeout = 4000)
    public void testPlusWeeks_ZeroWeeks() {
        DateMidnight dateMidnight = new DateMidnight(2023, 10, 1); // Example date
        DateMidnight result = dateMidnight.plusWeeks(0);
        assertEquals(dateMidnight, result); // Should return the same instance
    }

    @Test(timeout = 4000)
    public void testPlusWeeks_NegativeWeeks() {
        DateMidnight dateMidnight = new DateMidnight(2023, 10, 1); // Example date
        DateMidnight expectedDate = new DateMidnight(2023, 9, 24); // Expected date after subtracting 1 week
        DateMidnight result = dateMidnight.plusWeeks(-1);
        assertEquals(expectedDate, result);
    }

}