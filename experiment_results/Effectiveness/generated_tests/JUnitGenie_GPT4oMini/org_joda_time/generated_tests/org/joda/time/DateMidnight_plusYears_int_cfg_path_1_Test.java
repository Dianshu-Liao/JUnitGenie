package org.joda.time;
import org.joda.time.DateMidnight;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateMidnight_plusYears_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusYears_NonZeroYears() {
        DateMidnight dateMidnight = new DateMidnight(2020, 1, 1);
        DateMidnight result = dateMidnight.plusYears(2);
        DateMidnight expected = new DateMidnight(2022, 1, 1);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testPlusYears_ZeroYears() {
        DateMidnight dateMidnight = new DateMidnight(2020, 1, 1);
        DateMidnight result = dateMidnight.plusYears(0);
        assertEquals(dateMidnight, result);
    }

    @Test(timeout = 4000)
    public void testPlusYears_NegativeYears() {
        DateMidnight dateMidnight = new DateMidnight(2020, 1, 1);
        DateMidnight result = dateMidnight.plusYears(-1);
        DateMidnight expected = new DateMidnight(2019, 1, 1);
        assertEquals(expected, result);
    }

}