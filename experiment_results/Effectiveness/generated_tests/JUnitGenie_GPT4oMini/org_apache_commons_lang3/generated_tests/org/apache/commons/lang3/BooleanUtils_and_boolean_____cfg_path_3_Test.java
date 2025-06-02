package org.apache.commons.lang3;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

public class BooleanUtils_and_boolean_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAnd_withAllTrue() {
        boolean[] input = {true, true, true};
        assertTrue(BooleanUtils.and(input));
    }

    @Test(timeout = 4000)
    public void testAnd_withOneFalse() {
        boolean[] input = {true, false, true};
        assertFalse(BooleanUtils.and(input));
    }

    @Test(timeout = 4000)
    public void testAnd_withEmptyArray() {
        try {
            BooleanUtils.and(new boolean[]{});
        } catch (NullPointerException e) {
            // Expected behavior
        }
    }

    @Test(timeout = 4000)
    public void testAnd_withOneElementFalse() {
        boolean[] input = {false};
        assertFalse(BooleanUtils.and(input));
    }
    
    @Test(timeout = 4000)
    public void testAnd_withOneElementTrue() {
        boolean[] input = {true};
        assertTrue(BooleanUtils.and(input));
    }

}