package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_long_____long_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Given
        long[] array = {1, 2, 3, 4, 5};
        long[] valuesToRemove = {2, 4};

        // When
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        long[] expected = {1, 3, 5};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        // Given
        long[] array = {};
        long[] valuesToRemove = {2, 4};

        // When
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        long[] expected = {};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        // Given
        long[] array = {1, 2, 3};
        long[] valuesToRemove = {};

        // When
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        long[] expected = {1, 2, 3};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatches() {
        // Given
        long[] array = {1, 2, 3};
        long[] valuesToRemove = {4, 5};

        // When
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        long[] expected = {1, 2, 3};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllMatches() {
        // Given
        long[] array = {1, 2, 3};
        long[] valuesToRemove = {1, 2, 3};

        // When
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        long[] expected = {};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithDuplicates() {
        // Given
        long[] array = {1, 2, 2, 3, 4};
        long[] valuesToRemove = {2};

        // When
        long[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        long[] expected = {1, 3, 4};
        assertArrayEquals(expected, result);
    }

}