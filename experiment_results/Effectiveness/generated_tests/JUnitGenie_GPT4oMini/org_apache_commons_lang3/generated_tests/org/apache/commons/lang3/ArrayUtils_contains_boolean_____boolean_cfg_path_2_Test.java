package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_contains_boolean_____boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testContains_ValueFound() {
        boolean[] array = {true, false, true};
        boolean valueToFind = true;
        try {
            boolean result = ArrayUtils.contains(array, valueToFind);
            assertTrue(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContains_ValueNotFound() {
        boolean[] array = {false, false, false};
        boolean valueToFind = true;
        try {
            boolean result = ArrayUtils.contains(array, valueToFind);
            assertTrue(!result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}