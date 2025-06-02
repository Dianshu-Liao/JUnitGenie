package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ArrayUtils_contains_boolean_____boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testContainsWithEmptyArray() {
        boolean[] array = new boolean[0];
        boolean valueToFind = true; // can be true or false, as the array is empty
        try {
            boolean result = ArrayUtils.contains(array, valueToFind);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsWithNonEmptyArrayNotContainingValue() {
        boolean[] array = {false, false, false};
        boolean valueToFind = true; // value not in the array
        try {
            boolean result = ArrayUtils.contains(array, valueToFind);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}