package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_byte_____byte_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testInsertWithEmptyValuesAndValidIndex() {
        // Given
        int index = 0;
        byte[] array = new byte[]{1, 2, 3};
        byte[] values = new byte[]{};

        // When
        byte[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertArrayEquals(new byte[]{1, 2, 3}, result);
    }

    @Test(timeout = 4000)
    public void testInsertWithNullArray() {
        // Given
        int index = 0;
        byte[] array = null;
        byte[] values = new byte[]{4, 5};

        // When
        byte[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testInsertWithNegativeIndex() {
        // Given
        int index = -1;
        byte[] array = new byte[]{1, 2, 3};
        byte[] values = new byte[]{4, 5};

        // When
        try {
            ArrayUtils.insert(index, array, values);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Then
            assertEquals("Index: -1, Length: 3", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithIndexGreaterThanArrayLength() {
        // Given
        int index = 4;
        byte[] array = new byte[]{1, 2, 3};
        byte[] values = new byte[]{4, 5};

        // When
        try {
            ArrayUtils.insert(index, array, values);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Then
            assertEquals("Index: 4, Length: 3", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        // Given
        int index = 1;
        byte[] array = new byte[]{1, 2, 3};
        byte[] values = new byte[]{4, 5};

        // When
        byte[] result = ArrayUtils.insert(index, array, values);

        // Then
        assertArrayEquals(new byte[]{1, 4, 5, 2, 3}, result);
    }

}