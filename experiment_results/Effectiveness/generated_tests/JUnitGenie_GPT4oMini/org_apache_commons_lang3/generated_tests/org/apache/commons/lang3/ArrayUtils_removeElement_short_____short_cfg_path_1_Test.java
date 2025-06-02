package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElement_short_____short_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveElement_CloneArray() {
        // Given
        short[] array = {1, 2, 3, 4, 5};
        short element = 6; // Element not in the array

        // When
        short[] result = ArrayUtils.removeElement(array, element);

        // Then
        assertArrayEquals(array, result); // The array should remain unchanged
    }

    @Test(timeout = 4000)
    public void testRemoveElement_RemoveElement() {
        // Given
        short[] array = {1, 2, 3, 4, 5};
        short element = 3; // Element to be removed

        // When
        short[] result = ArrayUtils.removeElement(array, element);

        // Then
        short[] expected = {1, 2, 4, 5}; // Expected result after removal
        assertArrayEquals(expected, result);
    }

}