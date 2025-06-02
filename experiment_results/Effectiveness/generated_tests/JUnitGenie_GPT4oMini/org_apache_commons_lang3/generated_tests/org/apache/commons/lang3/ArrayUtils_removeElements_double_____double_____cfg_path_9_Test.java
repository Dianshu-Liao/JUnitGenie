package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_removeElements_double_____double_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Given
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] valuesToRemove = {2.0, 3.0};

        // When
        double[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        double[] expected = {1.0, 4.0};
        assertArrayEquals(expected, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        // Given
        double[] array = {};
        double[] valuesToRemove = {2.0, 3.0};

        // When
        double[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        assertArrayEquals(array, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        // Given
        double[] array = {1.0, 2.0, 3.0};
        double[] valuesToRemove = {};

        // When
        double[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        assertArrayEquals(array, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatches() {
        // Given
        double[] array = {1.0, 2.0, 3.0};
        double[] valuesToRemove = {4.0, 5.0};

        // When
        double[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        assertArrayEquals(array, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithDuplicates() {
        // Given
        double[] array = {1.0, 2.0, 2.0, 3.0};
        double[] valuesToRemove = {2.0};

        // When
        double[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        double[] expected = {1.0, 3.0};
        assertArrayEquals(expected, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithMutableInt() {
        // Given
        double[] array = {1.0, 2.0, 3.0};
        MutableInt count = new MutableInt(2); // Initial value must be 2
        double[] valuesToRemove = {2.0};

        // When
        double[] result = ArrayUtils.removeElements(array, valuesToRemove);

        // Then
        assertArrayEquals(new double[]{1.0, 3.0}, result, 0.0);
        // Ensure that decrementAndGet returns 1
        assertEquals(1, count.decrementAndGet());
    }


}