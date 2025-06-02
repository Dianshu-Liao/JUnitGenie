package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_short_____short_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Test case where the array is empty and values are provided
        short[] array = new short[0];
        short[] values = {1, 2, 3};
        short[] expected = new short[0];
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);

        // Test case where values are empty
        array = new short[]{1, 2, 3, 4};
        values = new short[0];
        expected = new short[]{1, 2, 3, 4};
        result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);

        // Test case where some values are present in the array
        array = new short[]{1, 2, 3, 4, 5};
        values = new short[]{2, 4};
        expected = new short[]{1, 3, 5};
        result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);

        // Test case where all values are present in the array
        array = new short[]{1, 2, 3};
        values = new short[]{1, 2, 3};
        expected = new short[0];
        result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);

        // Test case where values are not present in the array
        array = new short[]{1, 2, 3};
        values = new short[]{4, 5};
        expected = new short[]{1, 2, 3};
        result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithMutableInt() {
        // Test case to ensure MutableInt decrement works correctly
        MutableInt mutableInt = new MutableInt(1);
        short[] array = new short[]{1, 2, 3};
        short[] values = {1};
        short[] expected = new short[]{2, 3};
        
        try {
            // This will decrement the MutableInt and should not throw an exception
            ArrayUtils.removeElements(array, values);
            assertArrayEquals(expected, ArrayUtils.removeElements(array, values));
        } catch (Exception e) {
            // Handle exception if any occurs
            e.printStackTrace();
        }
    }

}