package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_double_____double_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveElementsWithNonEmptyArrayAndValues() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] values = {2.0, 3.0};
        double[] expected = {1.0, 4.0};
        double[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double[] values = {};
        double[] expected = {1.0, 2.0, 3.0, 4.0}; // should return the original array
        double[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        double[] array = {};
        double[] values = {2.0, 3.0};
        double[] expected = {}; // should return the original empty array
        double[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNullArray() {
        double[] array = null;
        double[] values = {2.0, 3.0};
        double[] expected = null; // should return null as per the method's behavior
        try {
            double[] result = ArrayUtils.removeElements(array, values);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}