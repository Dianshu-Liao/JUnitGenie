package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_double_____double_____cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Test case where both array and values are non-empty
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] values = {2.0, 3.0};
        double[] expected = {1.0, 4.0};
        double[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result, 0.0);

        // Test case where the array is empty
        double[] emptyArray = {};
        double[] valuesToRemove = {1.0, 2.0};
        double[] resultEmpty = ArrayUtils.removeElements(emptyArray, valuesToRemove);
        assertArrayEquals(emptyArray, resultEmpty, 0.0);

        // Test case where values to remove are empty
        double[] resultNoValues = ArrayUtils.removeElements(array, new double[]{});
        assertArrayEquals(array, resultNoValues, 0.0);

        // Test case where both array and values are null
        double[] resultNulls = ArrayUtils.removeElements(new double[0], new double[0]);
        assertArrayEquals(new double[0], resultNulls, 0.0);

        // Test case where values contain duplicates
        double[] valuesWithDuplicates = {2.0, 2.0, 3.0};
        double[] expectedWithDuplicates = {1.0, 4.0};
        double[] resultWithDuplicates = ArrayUtils.removeElements(array, valuesWithDuplicates);
        assertArrayEquals(expectedWithDuplicates, resultWithDuplicates, 0.0);
    }


}