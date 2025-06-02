package org.apache.commons.lang3;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RandomUtils_randomInt_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRandomInt_ValidRange() {
        RandomUtils randomUtils = new RandomUtils();
        int result = randomUtils.randomInt(0, 10);
        // The result should be between 0 (inclusive) and 10 (exclusive)
        assertEquals(true, result >= 0 && result < 10);
    }

    @Test(timeout = 4000)
    public void testRandomInt_SameStartEnd() {
        RandomUtils randomUtils = new RandomUtils();
        int result = randomUtils.randomInt(5, 5);
        // When startInclusive and endExclusive are the same, it should return the startInclusive value
        assertEquals(5, result);
    }

    @Test(timeout = 4000)
    public void testRandomInt_EndLessThanStart() {
        RandomUtils randomUtils = new RandomUtils();
        try {
            randomUtils.randomInt(10, 5);
        } catch (IllegalArgumentException e) {
            // Expected exception due to endExclusive < startInclusive
            assertEquals("Start value must be smaller or equal to end value.", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRandomInt_NegativeStart() {
        RandomUtils randomUtils = new RandomUtils();
        try {
            randomUtils.randomInt(-1, 10);
        } catch (IllegalArgumentException e) {
            // Expected exception due to startInclusive < 0
            assertEquals("Both range values must be non-negative.", e.getMessage());
        }
    }

}