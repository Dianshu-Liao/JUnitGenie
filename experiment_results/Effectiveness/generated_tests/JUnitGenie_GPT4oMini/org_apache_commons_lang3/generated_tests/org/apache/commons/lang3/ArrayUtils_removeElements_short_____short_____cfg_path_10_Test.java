package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_short_____short_____cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Given
        short[] array = new short[]{1, 2, 3, 4, 5};
        short[] values = new short[]{2, 4};

        // When
        short[] result = ArrayUtils.removeElements(array, values);

        // Then
        assertArrayEquals(new short[]{1, 3, 5}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        // Given
        short[] array = new short[0];
        short[] values = new short[]{2, 4};

        // When
        short[] result = ArrayUtils.removeElements(array, values);

        // Then
        assertArrayEquals(new short[0], result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        // Given
        short[] array = new short[]{1, 2, 3, 4, 5};
        short[] values = new short[0];

        // When
        short[] result = ArrayUtils.removeElements(array, values);

        // Then
        assertArrayEquals(new short[]{1, 2, 3, 4, 5}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatches() {
        // Given
        short[] array = new short[]{1, 2, 3, 4, 5};
        short[] values = new short[]{6, 7};

        // When
        short[] result = ArrayUtils.removeElements(array, values);

        // Then
        assertArrayEquals(new short[]{1, 2, 3, 4, 5}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllMatches() {
        // Given
        short[] array = new short[]{1, 2, 3, 4, 5};
        short[] values = new short[]{1, 2, 3, 4, 5};

        // When
        short[] result = ArrayUtils.removeElements(array, values);

        // Then
        assertArrayEquals(new short[0], result);
    }

}