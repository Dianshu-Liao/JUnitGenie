package org.joda.time;
import org.joda.time.DateMidnight;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateMidnight_withDurationAdded_long_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithDurationAdded_zeroDuration() {
        DateMidnight dateMidnight = new DateMidnight();
        DateMidnight result = dateMidnight.withDurationAdded(0, 5);
        assertEquals(dateMidnight, result);
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_zeroScalar() {
        DateMidnight dateMidnight = new DateMidnight();
        DateMidnight result = dateMidnight.withDurationAdded(5, 0);
        assertEquals(dateMidnight, result);
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_nonZeroDurationAndScalar() {
        DateMidnight dateMidnight = new DateMidnight();
        DateMidnight result = dateMidnight.withDurationAdded(5, 1);
        // Assuming the expected result is calculated based on the implementation
        // This is a placeholder for the expected value
        DateMidnight expected = dateMidnight.withMillis(dateMidnight.getMillis() + 5);
        assertEquals(expected, result);
    }

}