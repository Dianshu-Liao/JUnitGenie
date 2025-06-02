package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_insert_int_byte_____byte_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testInsertWithNullArrayAndEmptyValues() {
        // Given
        int index = 0;
        byte[] array = null;
        byte[] values = new byte[0];

        // When
        byte[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testInsertWithEmptyArrayAndEmptyValues() {
        // Given
        int index = 0;
        byte[] array = new byte[0];
        byte[] values = new byte[0];

        // When
        byte[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertArrayEquals(new byte[0], result);
    }

    @Test(timeout = 4000)
    public void testInsertWithNullArray() {
        // Given
        int index = 0;
        byte[] array = null;
        byte[] values = new byte[]{1, 2, 3};

        // When
        byte[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testInsertWithValidIndexAndEmptyValues() {
        // Given
        int index = 0;
        byte[] array = new byte[]{4, 5, 6};
        byte[] values = new byte[0];

        // When
        byte[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertArrayEquals(new byte[]{4, 5, 6}, result);
    }

}