package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_short_____short_____cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Given
        short[] array = {1, 2, 3, 4, 5};
        short[] values = {2, 4};

        // When
        short[] result = ArrayUtils.removeElements(array, values);

        // Then
        short[] expected = {1, 3, 5};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        // Given
        short[] array = {1, 2, 3, 4, 5};
        short[] values = {};

        // When
        short[] result = ArrayUtils.removeElements(array, values);

        // Then
        short[] expected = {1, 2, 3, 4, 5}; // No elements should be removed
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        // Given
        short[] array = {};
        short[] values = {2, 4};

        // When
        short[] result = ArrayUtils.removeElements(array, values);

        // Then
        short[] expected = {}; // No elements should be removed
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatches() {
        // Given
        short[] array = {1, 2, 3, 4, 5};
        short[] values = {6, 7};

        // When
        short[] result = ArrayUtils.removeElements(array, values);

        // Then
        short[] expected = {1, 2, 3, 4, 5}; // No elements should be removed
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsAllMatches() {
        // Given
        short[] array = {2, 2, 2, 2};
        short[] values = {2};

        // When
        short[] result = ArrayUtils.removeElements(array, values);

        // Then
        short[] expected = {}; // All elements should be removed
        assertArrayEquals(expected, result);
    }

}