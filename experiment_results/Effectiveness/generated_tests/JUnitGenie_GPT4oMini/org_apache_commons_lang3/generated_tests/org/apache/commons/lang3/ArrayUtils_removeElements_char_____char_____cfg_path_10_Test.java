package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_char_____char_____cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Given
        char[] array = new char[] {'a', 'b', 'c', 'd'};
        char[] values = new char[] {}; // empty values array

        // When
        char[] result = null;
        try {
            result = ArrayUtils.removeElements(array, values);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Then
        assertArrayEquals(new char[] {'a', 'b', 'c', 'd'}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithValues() {
        // Given
        char[] array = new char[] {'a', 'b', 'c', 'd'};
        char[] values = new char[] {'b', 'd'}; // values to remove

        // When
        char[] result = null;
        try {
            result = ArrayUtils.removeElements(array, values);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Then
        assertArrayEquals(new char[] {'a', 'c'}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        // Given
        char[] array = new char[] {};
        char[] values = new char[] {'b', 'd'}; // values to remove

        // When
        char[] result = null;
        try {
            result = ArrayUtils.removeElements(array, values);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Then
        assertArrayEquals(new char[] {}, result);
    }

}