package org.joda.time;
import org.joda.time.DateMidnight;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateMidnight_withDurationAdded_long_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWithDurationAdded_zeroDurationAndScalar() {
        DateMidnight dateMidnight = new DateMidnight();
        DateMidnight result = dateMidnight.withDurationAdded(0, 0);
        assertEquals(dateMidnight, result);
    }

}