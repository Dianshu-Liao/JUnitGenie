package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_removeElements_double_____double_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Test case where array is not empty and values to remove are present
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] valuesToRemove = {2.0, 3.0};
        double[] expected = {1.0, 4.0};
        double[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result, 0.001);

        // Test case where array is empty
        double[] emptyArray = {};
        double[] valuesToRemoveFromEmpty = {1.0};
        double[] resultFromEmpty = ArrayUtils.removeElements(emptyArray, valuesToRemoveFromEmpty);
        assertArrayEquals(emptyArray, resultFromEmpty, 0.001);

        // Test case where values to remove are empty
        double[] resultWithEmptyValues = ArrayUtils.removeElements(array, new double[]{});
        assertArrayEquals(array, resultWithEmptyValues, 0.001);

        // Test case where values to remove are not in the array
        double[] valuesNotInArray = {5.0, 6.0};
        double[] resultWithValuesNotInArray = ArrayUtils.removeElements(array, valuesNotInArray);
        assertArrayEquals(array, resultWithValuesNotInArray, 0.001);

        // Test case where values to remove are all present
        double[] allValuesToRemove = {1.0, 2.0, 3.0, 4.0};
        double[] expectedEmpty = {};
        double[] resultAllRemoved = ArrayUtils.removeElements(array, allValuesToRemove);
        assertArrayEquals(expectedEmpty, resultAllRemoved, 0.001);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithMutableInt() {
        // Test case to ensure MutableInt decrement works correctly
        MutableInt count = new MutableInt(1);
        assertEquals(1L, count.decrementAndGet()); // Specify long type explicitly
        assertEquals(0L, (long) count.getValue()); // Cast to long to resolve ambiguity
    }


}