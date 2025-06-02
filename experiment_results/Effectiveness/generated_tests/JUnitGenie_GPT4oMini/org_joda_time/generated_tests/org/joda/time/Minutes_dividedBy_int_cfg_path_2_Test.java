package org.joda.time;
import org.joda.time.Minutes;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Minutes_dividedBy_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDividedBy_DivisorIsOne_ReturnsSameInstance() {
        try {
            Minutes minutes = Minutes.minutes(10);
            Minutes result = minutes.dividedBy(1);
            assertEquals(minutes, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDividedBy_DivisorIsGreaterThanOne_ReturnsCorrectMinutes() {
        try {
            Minutes minutes = Minutes.minutes(10);
            Minutes result = minutes.dividedBy(2);
            assertEquals(Minutes.minutes(5), result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}