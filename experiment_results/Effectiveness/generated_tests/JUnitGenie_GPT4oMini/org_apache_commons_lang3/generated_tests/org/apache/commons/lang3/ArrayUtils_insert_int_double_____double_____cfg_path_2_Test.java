package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_double_____double_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testInsertWithIndexOutOfBounds() {
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {4.0, 5.0};

        try {
            ArrayUtils.insert(4, array, values); // Index out of bounds
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 4, Length: 3", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithEmptyValues() {
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {};

        double[] result = ArrayUtils.insert(1, array, values);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {4.0, 5.0};

        double[] result = ArrayUtils.insert(1, array, values);
        assertArrayEquals(new double[]{1.0, 4.0, 5.0, 2.0, 3.0}, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testInsertWithNullArray() {
        double[] values = {4.0, 5.0};

        double[] result = ArrayUtils.insert(0, null, values);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testInsertWithNegativeIndex() {
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {4.0, 5.0};

        try {
            ArrayUtils.insert(-1, array, values); // Negative index
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: -1, Length: 3", e.getMessage());
        }
    }

}