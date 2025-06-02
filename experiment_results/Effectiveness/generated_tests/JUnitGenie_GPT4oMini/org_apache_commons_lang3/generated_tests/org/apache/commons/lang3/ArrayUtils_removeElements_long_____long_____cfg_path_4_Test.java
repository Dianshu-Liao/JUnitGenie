package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_long_____long_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        long[] array = {1, 2, 3, 4, 5};
        long[] values = {2, 3};

        // Expected result after removing 2 and 3
        long[] expected = {1, 4, 5};

        // Call the focal method
        long[] result = ArrayUtils.removeElements(array, values);

        // Assert the result
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        long[] array = {};
        long[] values = {1, 2};

        // Expected result is the same empty array
        long[] expected = {};

        // Call the focal method
        long[] result = ArrayUtils.removeElements(array, values);

        // Assert the result
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        long[] array = {1, 2, 3};
        long[] values = {};

        // Expected result is the same array
        long[] expected = {1, 2, 3};

        // Call the focal method
        long[] result = ArrayUtils.removeElements(array, values);

        // Assert the result
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatches() {
        long[] array = {1, 2, 3};
        long[] values = {4, 5};

        // Expected result is the same array
        long[] expected = {1, 2, 3};

        // Call the focal method
        long[] result = ArrayUtils.removeElements(array, values);

        // Assert the result
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithSingleElement() {
        long[] array = {1};
        long[] values = {1};

        // Expected result is an empty array
        long[] expected = {};

        // Call the focal method
        long[] result = ArrayUtils.removeElements(array, values);

        // Assert the result
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithMultipleOccurrences() {
        long[] array = {1, 2, 2, 3, 4};
        long[] values = {2};

        // Expected result after removing one occurrence of 2
        long[] expected = {1, 2, 3, 4};

        // Call the focal method
        long[] result = ArrayUtils.removeElements(array, values);

        // Assert the result
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithDecrementAndGet() {
        long[] array = {1, 2, 3};
        long[] values = {2};

        // Create a MutableInt with value 1
        MutableInt count = new MutableInt(1);

        // Call decrementAndGet to ensure it goes to 0
        count.decrementAndGet();

        // Expected result after removing 2
        long[] expected = {1, 3};

        // Call the focal method
        long[] result = ArrayUtils.removeElements(array, values);

        // Assert the result
        assertArrayEquals(expected, result);
    }

}