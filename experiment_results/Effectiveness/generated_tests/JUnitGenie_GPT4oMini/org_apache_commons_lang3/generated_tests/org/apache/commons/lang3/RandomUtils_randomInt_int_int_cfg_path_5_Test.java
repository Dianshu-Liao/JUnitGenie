package org.apache.commons.lang3;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RandomUtils_randomInt_int_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testRandomInt_ValidRange() {
        RandomUtils randomUtils = new RandomUtils();
        int result = randomUtils.randomInt(0, 10);
        assertEquals(true, result >= 0 && result < 10);
    }

    @Test(timeout = 4000)
    public void testRandomInt_EqualStartAndEnd() {
        RandomUtils randomUtils = new RandomUtils();
        int result = randomUtils.randomInt(5, 5);
        assertEquals(5, result);
    }

    @Test(timeout = 4000)
    public void testRandomInt_StartGreaterThanEnd() {
        try {
            RandomUtils randomUtils = new RandomUtils();
            randomUtils.randomInt(10, 5);
        } catch (IllegalArgumentException e) {
            assertEquals("Start value must be smaller or equal to end value.", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRandomInt_NegativeStart() {
        try {
            RandomUtils randomUtils = new RandomUtils();
            randomUtils.randomInt(-1, 10);
        } catch (IllegalArgumentException e) {
            assertEquals("Both range values must be non-negative.", e.getMessage());
        }
    }

}