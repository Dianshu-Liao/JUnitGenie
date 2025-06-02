package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_byte_____byte_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testInsertWithEmptyValues() {
        byte[] array = {1, 2, 3};
        byte[] values = {};
        byte[] result = ArrayUtils.insert(1, array, values);
        assertArrayEquals(new byte[]{1, 2, 3}, result);
    }

    @Test(timeout = 4000)
    public void testInsertWithNullArray() {
        // Corrected the method call to use a byte array instead of a short
        byte[] result = ArrayUtils.insert(0, new byte[0], (byte) 1);
        assertArrayEquals(new byte[]{1}, result);
    }

    @Test(timeout = 4000)
    public void testInsertWithIndexOutOfBounds() {
        byte[] array = {1, 2, 3};
        try {
            ArrayUtils.insert(5, array, (byte) 4);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 5, Length: 3", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithNegativeIndex() {
        byte[] array = {1, 2, 3};
        try {
            ArrayUtils.insert(-1, array, (byte) 4);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: -1, Length: 3", e.getMessage());
        }
    }


}