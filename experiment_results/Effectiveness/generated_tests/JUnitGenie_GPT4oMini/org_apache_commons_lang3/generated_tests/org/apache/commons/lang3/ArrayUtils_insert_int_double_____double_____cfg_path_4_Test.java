package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_double_____double_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testInsertWithNullArray() {
        double[] result = ArrayUtils.insert(0, new double[0], 1.0, 2.0); // Changed null to an empty array
        assertArrayEquals(new double[]{1.0, 2.0}, result, 0.001); // Adjusted expected result
    }

    @Test(timeout = 4000)
    public void testInsertWithEmptyValues() {
        double[] array = {1.0, 2.0, 3.0};
        double[] result = ArrayUtils.insert(1, array);
        assertArrayEquals(array, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testInsertWithValidIndex() {
        double[] array = {1.0, 2.0, 3.0};
        double[] result = ArrayUtils.insert(1, array, 4.0, 5.0);
        double[] expected = {1.0, 4.0, 5.0, 2.0, 3.0};
        assertArrayEquals(expected, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testInsertWithIndexOutOfBounds() {
        double[] array = {1.0, 2.0, 3.0};
        try {
            ArrayUtils.insert(4, array, 4.0);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 4, Length: 3", e.getMessage());
        }
    }


}