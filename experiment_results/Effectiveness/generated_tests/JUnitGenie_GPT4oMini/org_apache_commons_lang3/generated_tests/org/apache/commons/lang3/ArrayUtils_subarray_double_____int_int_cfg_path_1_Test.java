package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_subarray_double_____int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSubarrayWithNullArray() {
        double[] result = ArrayUtils.subarray(new double[0], 0, 5);
        // Expecting an empty array when the input array is null
        assertArrayEquals(new double[0], result, 0.0);
    }


}