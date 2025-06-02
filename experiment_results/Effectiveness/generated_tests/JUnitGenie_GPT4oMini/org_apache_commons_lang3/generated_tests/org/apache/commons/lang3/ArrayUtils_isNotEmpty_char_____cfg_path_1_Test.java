package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ArrayUtils_isNotEmpty_char_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsNotEmptyWithNullArray() {
        char[] array = null;
        try {
            boolean result = ArrayUtils.isNotEmpty(array);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsNotEmptyWithEmptyArray() {
        char[] array = new char[0];
        try {
            boolean result = ArrayUtils.isNotEmpty(array);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}