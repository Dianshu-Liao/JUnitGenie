package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_double_____double_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] valuesToRemove = {2.0, 3.0};

        // Expected result after removing 2.0 and 3.0
        double[] expected = {1.0, 4.0, 5.0};

        // Call the focal method
        double[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Assert the result
        assertArrayEquals(expected, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        double[] array = {};
        double[] valuesToRemove = {1.0, 2.0};

        // Expected result is the same empty array
        double[] expected = {};

        // Call the focal method
        double[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Assert the result
        assertArrayEquals(expected, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        double[] array = {1.0, 2.0, 3.0};
        double[] valuesToRemove = {};

        // Expected result is the same array
        double[] expected = {1.0, 2.0, 3.0};

        // Call the focal method
        double[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Assert the result
        assertArrayEquals(expected, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatches() {
        double[] array = {1.0, 2.0, 3.0};
        double[] valuesToRemove = {4.0, 5.0};

        // Expected result is the same array
        double[] expected = {1.0, 2.0, 3.0};

        // Call the focal method
        double[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Assert the result
        assertArrayEquals(expected, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllMatches() {
        double[] array = {1.0, 2.0, 3.0};
        double[] valuesToRemove = {1.0, 2.0, 3.0};

        // Expected result is an empty array
        double[] expected = {};

        // Call the focal method
        double[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Assert the result
        assertArrayEquals(expected, result, 0.0);
    }

}