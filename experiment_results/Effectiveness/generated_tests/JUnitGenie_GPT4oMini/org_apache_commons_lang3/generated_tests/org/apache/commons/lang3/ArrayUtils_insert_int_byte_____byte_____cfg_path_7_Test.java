package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_insert_int_byte_____byte_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testInsertWithEmptyValues() {
        int index = 0;
        byte[] array = new byte[]{1, 2, 3};
        byte[] values = {};

        byte[] expected = new byte[]{1, 2, 3};
        byte[] result = null;

        try {
            result = ArrayUtils.insert(index, array, values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertArrayEquals(expected, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertIndexOutOfBounds() {
        int index = 4; // Index out of bounds for the array length 3
        byte[] array = new byte[]{1, 2, 3};
        byte[] values = new byte[]{4, 5};

        try {
            ArrayUtils.insert(index, array, values);
        } catch (Exception e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testInsertNormalCase() {
        int index = 1;
        byte[] array = new byte[]{1, 2, 3};
        byte[] values = new byte[]{4, 5};

        byte[] expected = new byte[]{1, 4, 5, 2, 3};
        byte[] result = null;

        try {
            result = ArrayUtils.insert(index, array, values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertArrayEquals(expected, result);
    }

}