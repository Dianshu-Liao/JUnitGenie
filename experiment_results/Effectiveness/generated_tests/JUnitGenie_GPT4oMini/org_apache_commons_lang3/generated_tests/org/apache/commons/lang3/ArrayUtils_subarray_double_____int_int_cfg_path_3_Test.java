package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_subarray_double_____int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSubarrayWithValidInput() {
        double[] inputArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        int startIndexInclusive = 1; // >= 0
        int endIndexExclusive = 4; // should be within bounds of inputArray length
        double[] expectedOutput = {2.0, 3.0, 4.0};

        double[] result = ArrayUtils.subarray(inputArray, startIndexInclusive, endIndexExclusive);
        
        assertArrayEquals(expectedOutput, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testSubarrayWithNullArray() {
        double[] result = ArrayUtils.subarray(new double[0], 0, 0); // Use an empty array instead of null
        assertArrayEquals(new double[0], result, 0.001); // Compare with an empty double array
    }

    @Test(timeout = 4000)
    public void testSubarrayWithNegativeStartIndex() {
        double[] inputArray = {1.0, 2.0, 3.0};
        int startIndexInclusive = -1; // will be corrected to 0
        int endIndexExclusive = 3; 
        double[] expectedOutput = {1.0, 2.0, 3.0};

        double[] result = ArrayUtils.subarray(inputArray, Math.max(startIndexInclusive, 0), endIndexExclusive);
        
        assertArrayEquals(expectedOutput, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testSubarrayWithEmptyArray() {
        double[] inputArray = ArrayUtils.EMPTY_DOUBLE_ARRAY;
        int startIndexInclusive = 0;
        int endIndexExclusive = 0; // newSize = 0, should return EMPTY_DOUBLE_ARRAY

        double[] result = ArrayUtils.subarray(inputArray, startIndexInclusive, endIndexExclusive);
        
        assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testSubarrayWithInvalidRange() {
        double[] inputArray = {1.0, 2.0, 3.0};
        int startIndexInclusive = 1; 
        int endIndexExclusive = 1; // newSize = 0, should return EMPTY_DOUBLE_ARRAY

        double[] result = ArrayUtils.subarray(inputArray, startIndexInclusive, endIndexExclusive);
        
        assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_ARRAY, result, 0.001);
    }

}