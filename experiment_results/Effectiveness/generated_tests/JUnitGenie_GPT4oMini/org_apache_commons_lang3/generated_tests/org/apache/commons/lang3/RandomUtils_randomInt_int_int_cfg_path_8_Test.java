package org.apache.commons.lang3;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RandomUtils_randomInt_int_int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testRandomInt_ValidInput_ReturnsStartInclusive() {
        RandomUtils randomUtils = new RandomUtils();
        int startInclusive = 5;
        int endExclusive = 5;

        int result = randomUtils.randomInt(startInclusive, endExclusive);
        assertEquals(startInclusive, result);
    }

    @Test(timeout = 4000)
    public void testRandomInt_EndExclusiveLessThanStartInclusive_ThrowsException() {
        RandomUtils randomUtils = new RandomUtils();
        int startInclusive = 10;
        int endExclusive = 5;

        try {
            randomUtils.randomInt(startInclusive, endExclusive);
        } catch (IllegalArgumentException e) {
            assertEquals("Start value must be smaller or equal to end value.", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRandomInt_StartInclusiveNegative_ThrowsException() {
        RandomUtils randomUtils = new RandomUtils();
        int startInclusive = -1;
        int endExclusive = 10;

        try {
            randomUtils.randomInt(startInclusive, endExclusive);
        } catch (IllegalArgumentException e) {
            assertEquals("Both range values must be non-negative.", e.getMessage());
        }
    }

}