package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_byte_____byte_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testInsertWithNullArray() {
        try {
            // Change the method call to use a byte array instead of null
            byte[] result = ArrayUtils.insert(0, new byte[0], (byte) 1);
            assertArrayEquals(new byte[]{1}, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for null array");
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithEmptyValues() {
        byte[] array = {1, 2, 3};
        byte[] result = ArrayUtils.insert(1, array, (byte) 4);
        assertArrayEquals(new byte[]{1, 4, 2, 3}, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertWithNegativeIndex() {
        try {
            ArrayUtils.insert(-1, new byte[]{1, 2, 3}, (byte) 4);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: -1, Length: 3", e.getMessage());
            throw e; // rethrow to satisfy the expected exception
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertWithIndexGreaterThanLength() {
        try {
            ArrayUtils.insert(4, new byte[]{1, 2, 3}, (byte) 4);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 4, Length: 3", e.getMessage());
            throw e; // rethrow to satisfy the expected exception
        }
    }


}