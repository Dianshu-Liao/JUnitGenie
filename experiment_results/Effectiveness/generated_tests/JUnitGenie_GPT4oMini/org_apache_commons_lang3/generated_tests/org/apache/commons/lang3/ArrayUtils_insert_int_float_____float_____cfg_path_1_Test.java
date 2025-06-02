package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_insert_int_float_____float_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testInsertWithEmptyValues() {
        // Given
        int index = 0;
        float[] array = {1.0f, 2.0f, 3.0f};
        float[] values = {}; // empty values

        // When
        float[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertArrayEquals(new float[]{1.0f, 2.0f, 3.0f}, result, 0.0f);
    }

    @Test(timeout = 4000)
    public void testInsertWithNullArray() {
        // Given
        int index = 0;
        float[] array = null;
        float[] values = {4.0f, 5.0f};

        // When
        float[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertArrayEquals(new float[]{4.0f, 5.0f}, result, 0.0f); // Corrected to check for expected result
    }

    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        // Given
        int index = 1;
        float[] array = {1.0f, 2.0f, 3.0f};
        float[] values = {4.0f, 5.0f};

        // When
        float[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertArrayEquals(new float[]{1.0f, 4.0f, 5.0f, 2.0f, 3.0f}, result, 0.0f);
    }

    @Test(timeout = 4000)
    public void testInsertWithIndexOutOfBounds() {
        // Given
        int index = 4; // out of bounds
        float[] array = {1.0f, 2.0f, 3.0f};
        float[] values = {4.0f};

        // When
        try {
            ArrayUtils.insert(index, array, values);
        } catch (IndexOutOfBoundsException e) {
            // Then
            assertEquals("Index: 4, Length: 3", e.getMessage());
        }
    }


}