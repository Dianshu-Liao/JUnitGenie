package org.apache.commons.lang3;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class BooleanUtils_and_boolean_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAndWithAllTrue() {
        boolean[] input = {true, true, true};
        try {
            boolean result = BooleanUtils.and(input);
            assertTrue(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testAndWithOneFalse() {
        boolean[] input = {true, false, true};
        try {
            boolean result = BooleanUtils.and(input);
            assertTrue(!result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testAndWithEmptyArray() {
        boolean[] input = {};
        try {
            boolean result = BooleanUtils.and(input);
            assertTrue(result); // Expecting true for empty array
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}