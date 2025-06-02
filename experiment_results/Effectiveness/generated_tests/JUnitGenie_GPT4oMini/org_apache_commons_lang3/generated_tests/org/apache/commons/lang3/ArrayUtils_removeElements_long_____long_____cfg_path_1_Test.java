package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_long_____long_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyArray() {
        long[] array = new long[0]; // @parameter0 must be an empty array
        long[] values = {1, 2, 3}; // values can be any long values

        long[] result = ArrayUtils.removeElements(array, values);
        
        // Since the input array is empty, the result should also be an empty array
        assertArrayEquals(new long[0], result);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyValues() {
        long[] array = {1, 2, 3}; // Non-empty array
        long[] values = new long[0]; // @parameter1 must be an empty array

        long[] result = ArrayUtils.removeElements(array, values);
        
        // Since the values array is empty, the result should be the same as the input array
        assertArrayEquals(array, result);
    }

}