package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ArrayUtils_isSameLength_Object_____Object_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsSameLength_DifferentLengths() {
        // Given
        Object[] array1 = new Object[3]; // Length 3
        Object[] array2 = new Object[5]; // Length 5

        // When
        boolean result = ArrayUtils.isSameLength(array1, array2);

        // Then
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsSameLength_EqualLengths() {
        // Given
        Object[] array1 = new Object[4]; // Length 4
        Object[] array2 = new Object[4]; // Length 4

        // When
        boolean result = ArrayUtils.isSameLength(array1, array2);

        // Then
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsSameLength_NullArray1() {
        // Given
        Object[] array1 = null; // Null array
        Object[] array2 = new Object[2]; // Length 2

        // When
        try {
            ArrayUtils.isSameLength(array1, array2);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testIsSameLength_NullArray2() {
        // Given
        Object[] array1 = new Object[2]; // Length 2
        Object[] array2 = null; // Null array

        // When
        try {
            ArrayUtils.isSameLength(array1, array2);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}