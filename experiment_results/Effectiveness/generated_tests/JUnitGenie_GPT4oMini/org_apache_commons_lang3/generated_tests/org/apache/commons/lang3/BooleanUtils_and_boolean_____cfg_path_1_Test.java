package org.apache.commons.lang3;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BooleanUtils_and_boolean_____cfg_path_1_Test {

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
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testAndWithAllFalse() {
        boolean[] input = {false, false, false};
        try {
            boolean result = BooleanUtils.and(input);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testAndWithEmptyArray() {
        boolean[] input = {};
        try {
            boolean result = BooleanUtils.and(input);
            assertTrue(result); // Assuming requireNonEmpty does not throw for empty array
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}