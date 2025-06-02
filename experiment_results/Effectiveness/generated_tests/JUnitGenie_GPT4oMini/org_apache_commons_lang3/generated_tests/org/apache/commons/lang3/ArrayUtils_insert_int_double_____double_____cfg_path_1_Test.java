package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_double_____double_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testInsertWithEmptyValues() {
        // Given
        int index = 0;
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {}; // empty values

        // When
        double[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testInsertWithNullArray() {
        // Given
        int index = 0;
        double[] array = null;
        double[] values = {4.0, 5.0};

        // When
        double[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        // Given
        int index = 1;
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {4.0, 5.0};

        // When
        double[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertArrayEquals(new double[]{1.0, 4.0, 5.0, 2.0, 3.0}, result, 0.001);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertWithIndexOutOfBounds() {
        // Given
        int index = 5; // out of bounds
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {4.0};

        // When
        try {
            ArrayUtils.insert(index, array, values);
        } catch (IndexOutOfBoundsException e) {
            // Then
            assertEquals("Index: 5, Length: 3", e.getMessage());
            throw e; // rethrow to satisfy the expected exception
        }
    }

}