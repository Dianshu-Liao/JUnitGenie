package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_double_____double_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyArray() {
        double[] array = new double[0]; // @parameter0 must be an empty array
        double[] values = {1.0, 2.0}; // values can be any double values

        try {
            double[] result = ArrayUtils.removeElements(array, values);
            assertArrayEquals(new double[0], result, 0.0); // Expecting an empty array as output
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyValues() {
        double[] array = {1.0, 2.0, 3.0}; // Non-empty array
        double[] values = new double[0]; // @parameter1 must be an empty array

        try {
            double[] result = ArrayUtils.removeElements(array, values);
            assertArrayEquals(array, result, 0.0); // Expecting the original array as output
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}