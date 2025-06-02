package org.joda.time;
import org.joda.time.Hours;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class Hours_minus_Hours_cfg_path_2_Test {
    
    @Test(timeout = 4000)
    public void testMinusWithNull() {
        Hours hours = Hours.hours(5);
        Hours result = hours.minus(null);
        
        // Verifying that the result remains the same as the original
        assertSame(hours, result);
    }

}