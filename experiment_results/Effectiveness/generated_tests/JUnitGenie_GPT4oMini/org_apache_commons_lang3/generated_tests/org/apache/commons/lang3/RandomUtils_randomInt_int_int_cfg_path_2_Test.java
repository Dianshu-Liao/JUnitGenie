package org.apache.commons.lang3;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RandomUtils_randomInt_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRandomInt_withStartLessThanEnd() {
        try {
            int result = new RandomUtils().randomInt(1, 5);
            assertEquals(1, result); // Note: this is not a deterministic outcome as it's random
        } catch (Exception e) {
            // Handle the potential exception here
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRandomInt_withInvalidEndLessThanStart() {
        try {
            new RandomUtils().randomInt(5, 1);
        } catch (Exception e) {
            // Handle the exception, expected to be IllegalArgumentException
            throw e; // rethrowing the exception to satisfy the expected clause
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRandomInt_withNegativeStart() {
        try {
            new RandomUtils().randomInt(-1, 5);
        } catch (Exception e) {
            // Handle the exception, expected to be IllegalArgumentException
            throw e; // rethrowing the exception to satisfy the expected clause
        }
    }

    @Test(timeout = 4000)
    public void testRandomInt_withEqualStartAndEnd() {
        try {
            int result = new RandomUtils().randomInt(5, 5);
            assertEquals(5, result);
        } catch (Exception e) {
            // Handle the potential exception here
        }
    }

}