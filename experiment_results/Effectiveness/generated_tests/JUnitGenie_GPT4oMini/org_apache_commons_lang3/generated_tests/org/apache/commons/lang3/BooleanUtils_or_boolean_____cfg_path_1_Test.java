package org.apache.commons.lang3;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BooleanUtils_or_boolean_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testOrWithTrueValues() {
        boolean[] input = {true, false, false};
        boolean result = BooleanUtils.or(input);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testOrWithAllFalseValues() {
        boolean[] input = {false, false, false};
        boolean result = BooleanUtils.or(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testOrWithEmptyArray() {
        try {
            boolean result = BooleanUtils.or(new boolean[]{});
        } catch (IllegalArgumentException e) {
            // Expected exception for empty array
        }
    }

}