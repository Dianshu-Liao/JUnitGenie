package org.apache.commons.lang3;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.lang3.ArrayUtils;

public class ArrayUtils_isNotEmpty_short_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsNotEmpty_withNonEmptyArray() {
        short[] array = {1, 2, 3}; // Valid short array
        boolean result = ArrayUtils.isNotEmpty(array);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsNotEmpty_withEmptyArray() {
        short[] array = {}; // Empty array
        boolean result = ArrayUtils.isNotEmpty(array);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsNotEmpty_withNullArray() {
        short[] array = null; // Null array
        boolean result = ArrayUtils.isNotEmpty(array);
        assertFalse(result);
    }

}