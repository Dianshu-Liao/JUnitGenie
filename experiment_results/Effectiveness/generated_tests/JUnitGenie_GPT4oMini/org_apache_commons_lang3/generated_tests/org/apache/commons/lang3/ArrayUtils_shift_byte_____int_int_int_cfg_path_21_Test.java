package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_shift_byte_____int_int_int_cfg_path_21_Test {

    @Test(timeout = 4000)
    public void testShiftWithNullArray() {
        byte[] array = null;
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = 2;

        try {
            ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
            // No exception expected, method should return without doing anything
        } catch (Exception e) {
            // Handle unexpected exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testShiftWithStartIndexOutOfBounds() {
        byte[] array = new byte[5];
        int startIndexInclusive = 5; // Out of bounds
        int endIndexExclusive = 5;
        int offset = 2;

        try {
            ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
            // No exception expected, method should return without doing anything
        } catch (Exception e) {
            // Handle unexpected exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testShiftWithEndIndexLessThanOrEqualToZero() {
        byte[] array = new byte[5];
        int startIndexInclusive = 0;
        int endIndexExclusive = 0; // Invalid end index
        int offset = 2;

        try {
            ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
            // No exception expected, method should return without doing anything
        } catch (Exception e) {
            // Handle unexpected exception
            e.printStackTrace();
        }
    }

}