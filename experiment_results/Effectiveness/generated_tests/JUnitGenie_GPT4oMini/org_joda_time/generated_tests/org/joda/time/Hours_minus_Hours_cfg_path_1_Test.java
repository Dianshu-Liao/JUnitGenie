package org.joda.time;
import org.joda.time.Hours;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Hours_minus_Hours_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMinusWithNonNullHours() {
        Hours hours1 = Hours.hours(5);
        Hours hours2 = Hours.hours(3);
        
        Hours result = hours1.minus(hours2);
        
        // Expected result is 2 hours
        assertEquals(Hours.hours(2), result);
    }

    @Test(timeout = 4000)
    public void testMinusWithNullHours() {
        Hours hours1 = Hours.hours(5);
        
        Hours result = hours1.minus(null);
        
        // Expected result is the same as hours1
        assertEquals(hours1, result);
    }

    @Test(timeout = 4000)
    public void testMinusWithPositiveValue() {
        Hours hours1 = Hours.hours(5);
        Hours hours2 = Hours.hours(1);
        
        Hours result = hours1.minus(hours2);
        
        // Expected result is 4 hours
        assertEquals(Hours.hours(4), result);
    }

    @Test(timeout = 4000)
    public void testMinusWithMaxIntegerValue() {
        Hours hours1 = Hours.hours(5);
        Hours hours2 = Hours.hours(Integer.MAX_VALUE);
        
        try {
            hours1.minus(hours2);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}