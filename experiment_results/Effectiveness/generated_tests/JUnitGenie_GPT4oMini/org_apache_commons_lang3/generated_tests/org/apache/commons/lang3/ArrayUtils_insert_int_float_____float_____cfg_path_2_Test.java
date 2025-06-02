package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_float_____float_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testInsert_IndexOutOfBoundsException() {
        // Given
        int index = 1;
        float[] array = {1.0f, 2.0f, 3.0f};
        float[] values = {4.0f, 5.0f};

        // When & Then
        try {
            ArrayUtils.insert(index, array, values);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 1, Length: 3", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsert_EmptyValues() {
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
    public void testInsert_NullArray() {
        // Given
        int index = 0;
        float[] array = null;
        float[] values = {4.0f, 5.0f};

        // When
        float[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testInsert_ValidInsertion() {
        // Given
        int index = 1;
        float[] array = {1.0f, 2.0f, 3.0f};
        float[] values = {4.0f, 5.0f};

        // When
        float[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertArrayEquals(new float[]{1.0f, 4.0f, 5.0f, 2.0f, 3.0f}, result, 0.0f);
    }

}