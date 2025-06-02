package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_isNotEmpty_byte_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsNotEmpty_withNonEmptyArray() {
        byte[] nonEmptyArray = {1, 2, 3};
        try {
            boolean result = ArrayUtils.isNotEmpty(nonEmptyArray);
            assertTrue(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsNotEmpty_withEmptyArray() {
        byte[] emptyArray = {};
        try {
            boolean result = ArrayUtils.isNotEmpty(emptyArray);
            assertTrue(!result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsNotEmpty_withNullArray() {
        byte[] nullArray = null;
        try {
            boolean result = ArrayUtils.isNotEmpty(nullArray);
            assertTrue(!result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}