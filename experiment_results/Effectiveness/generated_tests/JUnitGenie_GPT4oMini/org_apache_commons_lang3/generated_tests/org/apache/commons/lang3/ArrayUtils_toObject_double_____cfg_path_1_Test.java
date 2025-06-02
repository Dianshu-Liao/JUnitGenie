package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toObject_double_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToObject_withValidArray() {
        double[] input = {1.0, 2.0, 3.0};
        Double[] expected = {1.0, 2.0, 3.0};
        Double[] result = null;
        try {
            result = ArrayUtils.toObject(input);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToObject_withEmptyArray() {
        double[] input = {};
        Double[] expected = ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY;
        Double[] result = null;
        try {
            result = ArrayUtils.toObject(input);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToObject_withNullArray() {
        double[] input = null;
        Double[] result = null;
        try {
            result = ArrayUtils.toObject(input);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        assertArrayEquals(null, result);
    }

}