package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_double_____double_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testInsertWithNullArray() {
        double[] result = ArrayUtils.insert(0, new double[0], 1.0, 2.0); // Changed null to new double[0]
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testInsertWithEmptyValues() {
        double[] array = {1.0, 2.0, 3.0};
        double[] result = ArrayUtils.insert(1, array, new double[0]); // Added empty double array
        assertArrayEquals(array, result, 0.0001); // Added delta for double comparison
    }

    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {4.0, 5.0};
        double[] result = ArrayUtils.insert(1, array, values);
        double[] expected = {1.0, 4.0, 5.0, 2.0, 3.0};
        assertArrayEquals(expected, result, 0.0001);
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