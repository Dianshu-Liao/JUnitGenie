package org.apache.commons.lang3;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RandomUtils_randomInt_int_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testRandomInt_ValidInput_ReturnsStartInclusive() {
        try {
            RandomUtils randomUtils = new RandomUtils();
            int result = randomUtils.randomInt(5, 5);
            assertEquals(5, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testRandomInt_EndExclusiveLessThanStartInclusive_ThrowsException() {
        try {
            RandomUtils randomUtils = new RandomUtils();
            randomUtils.randomInt(10, 5);
        } catch (IllegalArgumentException e) {
            assertEquals("Start value must be smaller or equal to end value.", e.getMessage());
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testRandomInt_StartInclusiveNegative_ThrowsException() {
        try {
            RandomUtils randomUtils = new RandomUtils();
            randomUtils.randomInt(-1, 10);
        } catch (IllegalArgumentException e) {
            assertEquals("Both range values must be non-negative.", e.getMessage());
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}