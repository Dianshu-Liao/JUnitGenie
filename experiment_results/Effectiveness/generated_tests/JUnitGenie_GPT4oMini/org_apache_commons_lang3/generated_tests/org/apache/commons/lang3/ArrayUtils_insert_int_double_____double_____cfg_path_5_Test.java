package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_double_____double_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testInsertWithEmptyValues() {
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {}; // empty values
        double[] result = ArrayUtils.insert(1, array, values);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, result, 0.001);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertWithNegativeIndex() {
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {4.0};
        try {
            ArrayUtils.insert(-1, array, values);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: -1, Length: 3", e.getMessage());
            throw e; // rethrow to satisfy the expected exception
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertWithIndexGreaterThanLength() {
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {4.0};
        try {
            ArrayUtils.insert(4, array, values);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 4, Length: 3", e.getMessage());
            throw e; // rethrow to satisfy the expected exception
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithValidIndex() {
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {4.0, 5.0};
        double[] result = ArrayUtils.insert(1, array, values);
        assertArrayEquals(new double[]{1.0, 4.0, 5.0, 2.0, 3.0}, result, 0.001);
    }

}