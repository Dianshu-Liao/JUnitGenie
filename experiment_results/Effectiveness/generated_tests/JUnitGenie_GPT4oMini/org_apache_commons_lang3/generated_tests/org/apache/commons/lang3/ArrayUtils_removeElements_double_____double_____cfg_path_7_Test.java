package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_double_____double_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Given
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] values = {2.0, 3.0};

        // When
        double[] result = ArrayUtils.removeElements(array, values);

        // Then
        double[] expected = {1.0, 4.0};
        assertArrayEquals(expected, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        // Given
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] values = {}; // empty values

        // When
        double[] result = ArrayUtils.removeElements(array, values);

        // Then
        double[] expected = {1.0, 2.0, 3.0, 4.0}; // should return the original array
        assertArrayEquals(expected, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNullValues() {
        // Given
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] values = null; // null values

        // When
        double[] result = ArrayUtils.removeElements(array, values);

        // Then
        double[] expected = {1.0, 2.0, 3.0, 4.0}; // should return the original array
        assertArrayEquals(expected, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatch() {
        // Given
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] values = {5.0}; // no match

        // When
        double[] result = ArrayUtils.removeElements(array, values);

        // Then
        double[] expected = {1.0, 2.0, 3.0, 4.0}; // should return the original array
        assertArrayEquals(expected, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllMatch() {
        // Given
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {1.0, 2.0, 3.0}; // all elements match

        // When
        double[] result = ArrayUtils.removeElements(array, values);

        // Then
        double[] expected = {}; // should return an empty array
        assertArrayEquals(expected, result, 0.0);
    }

}