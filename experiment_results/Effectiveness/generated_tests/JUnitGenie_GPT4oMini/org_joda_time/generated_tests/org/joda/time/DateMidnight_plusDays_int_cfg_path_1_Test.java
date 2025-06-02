package org.joda.time;
import org.joda.time.DateMidnight;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateMidnight_plusDays_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPlusDays_NonZeroDays() {
        DateMidnight dateMidnight = new DateMidnight(2023, 10, 1);
        DateMidnight result = dateMidnight.plusDays(5);
        DateMidnight expected = new DateMidnight(2023, 10, 6);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testPlusDays_ZeroDays() {
        DateMidnight dateMidnight = new DateMidnight(2023, 10, 1);
        DateMidnight result = dateMidnight.plusDays(0);
        assertEquals(dateMidnight, result);
    }

    @Test(timeout = 4000)
    public void testPlusDays_NegativeDays() {
        DateMidnight dateMidnight = new DateMidnight(2023, 10, 1);
        DateMidnight result = dateMidnight.plusDays(-3);
        DateMidnight expected = new DateMidnight(2023, 9, 28);
        assertEquals(expected, result);
    }

}