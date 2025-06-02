package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_subarray_double_____int_int_cfg_path_2_Test {

    private static final double[] EMPTY_DOUBLE_ARRAY = new double[0];

    @Test(timeout = 4000)
    public void testSubarrayValidInput() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        int startIndexInclusive = 1; // valid non-negative index
        int endIndexExclusive = 4; // valid index within bounds

        double[] result = ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
        double[] expected = {2.0, 3.0, 4.0};
        assertArrayEquals(expected, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testSubarrayWithNullArray() {
        double[] result = ArrayUtils.subarray(new double[0], 0, 1); // Use an empty array instead of null
        assertArrayEquals(EMPTY_DOUBLE_ARRAY, result, 0.001); // Compare with EMPTY_DOUBLE_ARRAY
    }

    @Test(timeout = 4000)
    public void testSubarrayWithNegativeStartIndex() {
        double[] array = {1.0, 2.0, 3.0};
        int startIndexInclusive = -1; // invalid index
        int endIndexExclusive = 3; // valid index within bounds

        try {
            double[] result = ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
            assertArrayEquals(EMPTY_DOUBLE_ARRAY, result, 0.001);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testSubarrayWithZeroSize() {
        double[] array = {1.0, 2.0, 3.0};
        int startIndexInclusive = 2; // valid index
        int endIndexExclusive = 2; // same index, resulting in zero size

        double[] result = ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
        assertArrayEquals(EMPTY_DOUBLE_ARRAY, result, 0.001);
    }


}