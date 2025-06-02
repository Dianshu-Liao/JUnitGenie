package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_byte_____byte_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testInsertWithEmptyValues() {
        try {
            int index = 0;
            byte[] array = new byte[]{1, 2, 3};
            byte[] values = new byte[0]; // empty array to satisfy isEmpty condition

            byte[] result = ArrayUtils.insert(index, array, values);
            assertArrayEquals(new byte[]{1, 2, 3}, result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertWithNegativeIndex() {
        int index = -1;
        byte[] array = new byte[]{1, 2, 3};
        byte[] values = new byte[]{4, 5};

        ArrayUtils.insert(index, array, values);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertWithIndexGreaterThanArrayLength() {
        int index = 4; // index greater than array length
        byte[] array = new byte[]{1, 2, 3};
        byte[] values = new byte[]{4, 5};

        ArrayUtils.insert(index, array, values);
    }

}