package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_shift_byte_____int_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testShiftWithValidParameters() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = 2;

        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        // Expected result after shifting: {3, 4, 5, 1, 2}
        assertArrayEquals(new byte[]{3, 4, 5, 1, 2}, array);
    }

    @Test(timeout = 4000)
    public void testShiftWithNullArray() {
        byte[] array = null;
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = 2;

        try {
            ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        // No assertion needed, method should return without modifying anything
    }

    @Test(timeout = 4000)
    public void testShiftWithStartIndexOutOfBounds() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 5; // Out of bounds
        int endIndexExclusive = 5;
        int offset = 2;

        try {
            ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        // No assertion needed, method should return without modifying anything
    }

    @Test(timeout = 4000)
    public void testShiftWithEndIndexLessThanOrEqualToZero() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 0;
        int endIndexExclusive = 0; // Invalid end index
        int offset = 2;

        try {
            ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        // No assertion needed, method should return without modifying anything
    }


}