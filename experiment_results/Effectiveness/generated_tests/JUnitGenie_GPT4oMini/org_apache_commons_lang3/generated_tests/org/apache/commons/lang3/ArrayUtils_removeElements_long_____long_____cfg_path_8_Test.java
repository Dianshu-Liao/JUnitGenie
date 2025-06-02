package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_long_____long_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Given
        long[] array = new long[] {1, 2, 3, 4, 5};
        long[] values = new long[] {}; // empty values array

        // When
        long[] result = ArrayUtils.removeElements(array, values);

        // Then
        assertArrayEquals(new long[] {1, 2, 3, 4, 5}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithValues() {
        // Given
        long[] array = new long[] {1, 2, 3, 4, 5};
        long[] values = new long[] {2, 4}; // values to remove

        // When
        long[] result = ArrayUtils.removeElements(array, values);

        // Then
        assertArrayEquals(new long[] {1, 3, 5}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        // Given
        long[] array = new long[] {};
        long[] values = new long[] {1, 2}; // values to remove

        // When
        long[] result = ArrayUtils.removeElements(array, values);

        // Then
        assertArrayEquals(new long[] {}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllValuesRemoved() {
        // Given
        long[] array = new long[] {1, 2, 3};
        long[] values = new long[] {1, 2, 3}; // all values to remove

        // When
        long[] result = ArrayUtils.removeElements(array, values);

        // Then
        assertArrayEquals(new long[] {}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatchingValues() {
        // Given
        long[] array = new long[] {1, 2, 3};
        long[] values = new long[] {4, 5}; // no matching values

        // When
        long[] result = ArrayUtils.removeElements(array, values);

        // Then
        assertArrayEquals(new long[] {1, 2, 3}, result);
    }

}