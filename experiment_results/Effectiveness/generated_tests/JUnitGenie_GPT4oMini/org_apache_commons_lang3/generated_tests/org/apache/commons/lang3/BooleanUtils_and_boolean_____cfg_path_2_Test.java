package org.apache.commons.lang3;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BooleanUtils_and_boolean_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAnd_WithAllTrue() {
        boolean[] input = {true, true, true};
        boolean result = BooleanUtils.and(input);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testAnd_WithOneFalse() {
        boolean[] input = {true, false, true};
        boolean result = BooleanUtils.and(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testAnd_WithAllFalse() {
        boolean[] input = {false, false, false};
        boolean result = BooleanUtils.and(input);
        assertFalse(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnd_WithEmptyArray() {
        boolean[] input = {};
        try {
            BooleanUtils.and(input);
        } catch (IllegalArgumentException e) {
            // Exception expected
            throw e;
        }
    }

    @Test(timeout = 4000)
    public void testAnd_WithNullArray() {
        boolean[] input = null;
        try {
            BooleanUtils.and(input);
        } catch (IllegalArgumentException e) {
            // Exception expected
            throw e;
        }
    }

}