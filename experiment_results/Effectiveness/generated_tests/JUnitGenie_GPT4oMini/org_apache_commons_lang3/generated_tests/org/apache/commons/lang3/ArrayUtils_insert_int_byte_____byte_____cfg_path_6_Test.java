package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_byte_____byte_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testInsertWithNullArrayAndEmptyValues() {
        byte[] result = ArrayUtils.insert(0, null, new byte[]{});
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        byte[] array = new byte[]{1, 2, 3};
        byte[] values = new byte[]{9, 8};
        byte[] result = ArrayUtils.insert(1, array, values);
        assertArrayEquals(new byte[]{1, 9, 8, 2, 3}, result);
    }

    @Test(timeout = 4000)
    public void testInsertWithIndexAtTheStart() {
        byte[] array = new byte[]{1, 2, 3};
        byte[] values = new byte[]{4};
        byte[] result = ArrayUtils.insert(0, array, values);
        assertArrayEquals(new byte[]{4, 1, 2, 3}, result);
    }

    @Test(timeout = 4000)
    public void testInsertWithIndexAtTheEnd() {
        byte[] array = new byte[]{1, 2, 3};
        byte[] values = new byte[]{4};
        byte[] result = ArrayUtils.insert(3, array, values);
        assertArrayEquals(new byte[]{1, 2, 3, 4}, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertWithNegativeIndex() {
        byte[] array = new byte[]{1, 2, 3};
        byte[] values = new byte[]{4};
        try {
            ArrayUtils.insert(-1, array, values);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: -1, Length: 3", e.getMessage());
            throw e;
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertWithIndexGreaterThanLength() {
        byte[] array = new byte[]{1, 2, 3};
        byte[] values = new byte[]{4};
        try {
            ArrayUtils.insert(4, array, values);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 4, Length: 3", e.getMessage());
            throw e;
        }
    }

}