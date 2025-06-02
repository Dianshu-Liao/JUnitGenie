package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

public class RandomUtils_randomBytes_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRandomBytes_withValidCount() {
        RandomUtils randomUtils = new RandomUtils();
        int count = 10;
        byte[] result = randomUtils.randomBytes(count);
        // Check that the result is of the expected length
        assertArrayEquals(new byte[count], result); // Fixed to compare result with expected
    }

    @Test(timeout = 4000)
    public void testRandomBytes_withNegativeCount() {
        RandomUtils randomUtils = new RandomUtils();
        int count = -1;

        try {
            randomUtils.randomBytes(count);
        } catch (IllegalArgumentException e) {
            // Check that the exception message is as expected
            assertEquals("Count cannot be negative.", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRandomBytes_withCountZero() {
        RandomUtils randomUtils = new RandomUtils();
        int count = 0;
        byte[] result = randomUtils.randomBytes(count);
        // Check that the result is an empty array
        assertArrayEquals(new byte[0], result);
    }


}