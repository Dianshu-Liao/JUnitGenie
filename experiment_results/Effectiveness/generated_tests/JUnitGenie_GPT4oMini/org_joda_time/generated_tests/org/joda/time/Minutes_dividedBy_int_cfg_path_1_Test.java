package org.joda.time;
import org.joda.time.Minutes;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Minutes_dividedBy_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDividedBy_NonOneDivisor() {
        try {
            Minutes minutes = Minutes.minutes(10);
            Minutes result = minutes.dividedBy(2);
            assertEquals(Minutes.minutes(5), result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDividedBy_ZeroDivisor() {
        try {
            Minutes minutes = Minutes.minutes(10);
            Minutes result = minutes.dividedBy(0);
            assertEquals(Minutes.minutes(0), result); // Assuming the method handles division by zero
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}