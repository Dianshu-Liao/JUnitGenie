package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_short_____short_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Given
        short[] array = {1, 2, 3, 4, 5};
        short[] valuesToRemove = {2, 4};

        // When
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        short[] expected = {1, 3, 5};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        // Given
        short[] array = {1, 2, 3, 4, 5};
        short[] valuesToRemove = {};

        // When
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        short[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        // Given
        short[] array = {};
        short[] valuesToRemove = {1, 2};

        // When
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        short[] expected = {};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatches() {
        // Given
        short[] array = {1, 2, 3};
        short[] valuesToRemove = {4, 5};

        // When
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        short[] expected = {1, 2, 3};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllMatches() {
        // Given
        short[] array = {1, 1, 1};
        short[] valuesToRemove = {1};

        // When
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        short[] expected = {};
        assertArrayEquals(expected, result);
    }

}