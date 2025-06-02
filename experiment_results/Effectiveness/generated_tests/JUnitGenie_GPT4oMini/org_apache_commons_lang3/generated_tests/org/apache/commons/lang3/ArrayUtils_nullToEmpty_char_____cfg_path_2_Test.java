package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_nullToEmpty_char_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNullToEmptyWithNullArray() {
        char[] input = null;
        char[] expected = ArrayUtils.EMPTY_CHAR_ARRAY;
        
        try {
            char[] result = ArrayUtils.nullToEmpty(input);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}