package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_double_____double_____cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Test case where array is not empty and values to remove are present
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] values = {2.0, 3.0};
        double[] expected = {1.0, 4.0};
        double[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result, 0.0);

        // Test case where array is not empty and values to remove are not present
        double[] array2 = {1.0, 2.0, 3.0};
        double[] values2 = {4.0, 5.0};
        double[] expected2 = {1.0, 2.0, 3.0};
        double[] result2 = ArrayUtils.removeElements(array2, values2);
        assertArrayEquals(expected2, result2, 0.0);

        // Test case where array is empty
        double[] array3 = {};
        double[] values3 = {1.0, 2.0};
        double[] expected3 = {};
        double[] result3 = ArrayUtils.removeElements(array3, values3);
        assertArrayEquals(expected3, result3, 0.0);

        // Test case where values to remove are empty
        double[] array4 = {1.0, 2.0, 3.0};
        double[] values4 = {};
        double[] expected4 = {1.0, 2.0, 3.0};
        double[] result4 = ArrayUtils.removeElements(array4, values4);
        assertArrayEquals(expected4, result4, 0.0);
    }

}