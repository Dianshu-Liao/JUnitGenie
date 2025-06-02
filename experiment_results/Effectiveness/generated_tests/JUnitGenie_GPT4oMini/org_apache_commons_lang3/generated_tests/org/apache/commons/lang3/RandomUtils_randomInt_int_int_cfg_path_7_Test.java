package org.apache.commons.lang3;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RandomUtils_randomInt_int_int_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testRandomInt_ValidRange() {
        RandomUtils randomUtils = new RandomUtils();
        int startInclusive = 0;
        int endExclusive = 10;
        
        int result = 0;
        try {
            result = randomUtils.randomInt(startInclusive, endExclusive);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
        
        // Assertions
        assertEquals(true, result >= startInclusive && result < endExclusive);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRandomInt_EndExclusiveLessThanStartInclusive() {
        RandomUtils randomUtils = new RandomUtils();
        int startInclusive = 10;
        int endExclusive = 5;
        
        try {
            randomUtils.randomInt(startInclusive, endExclusive);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRandomInt_NegativeStartInclusive() {
        RandomUtils randomUtils = new RandomUtils();
        int startInclusive = -1;
        int endExclusive = 10;

        try {
            randomUtils.randomInt(startInclusive, endExclusive);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testRandomInt_SingleValueRange() {
        RandomUtils randomUtils = new RandomUtils();
        int startInclusive = 5;
        int endExclusive = 5;

        int result = 0;
        try {
            result = randomUtils.randomInt(startInclusive, endExclusive);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
        
        // Assertions
        assertEquals(startInclusive, result);
    }

}