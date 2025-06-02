package org.apache.commons.lang3;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomUtils_randomInt_int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRandomInt_ValidRange() {
        RandomUtils randomUtils = new RandomUtils();
        int result = randomUtils.randomInt(0, 10);
        assertTrue("Result should be within the range [0, 10)", result >= 0 && result < 10);
    }

    @Test(timeout = 4000)
    public void testRandomInt_EqualStartAndEnd() {
        RandomUtils randomUtils = new RandomUtils();
        int result = randomUtils.randomInt(5, 5);
        assertEquals(5, result);
    }

    @Test(timeout = 4000)
    public void testRandomInt_StartGreaterThanEnd() {
        RandomUtils randomUtils = new RandomUtils();
        try {
            randomUtils.randomInt(10, 5);
            fail("Expected an exception to be thrown due to invalid range");
        } catch (IllegalArgumentException e) {
            assertEquals("Start value must be smaller or equal to end value.", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRandomInt_NegativeStart() {
        RandomUtils randomUtils = new RandomUtils();
        try {
            randomUtils.randomInt(-1, 10);
            fail("Expected an exception to be thrown due to negative start value");
        } catch (IllegalArgumentException e) {
            assertEquals("Both range values must be non-negative.", e.getMessage());
        }
    }

}