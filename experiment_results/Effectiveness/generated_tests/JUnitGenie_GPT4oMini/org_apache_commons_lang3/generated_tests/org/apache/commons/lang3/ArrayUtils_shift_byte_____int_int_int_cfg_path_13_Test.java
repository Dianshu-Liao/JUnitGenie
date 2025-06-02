package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_shift_byte_____int_int_int_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testShiftWithEmptyArray() {
        byte[] array = new byte[0];
        int startIndexInclusive = 0;
        int endIndexExclusive = 0;
        int offset = 0;

        // Since the array is empty, we expect no changes to the array
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        
        // Verify that the array remains empty
        assertArrayEquals(new byte[0], array);
    }

    @Test(timeout = 4000)
    public void testShiftWithValidParameters() {
        byte[] array = new byte[]{1, 2, 3, 4, 5};
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = 2;

        // Perform the shift operation
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        
        // Verify the expected result after shifting
        assertArrayEquals(new byte[]{4, 5, 1, 2, 3}, array);
    }

    @Test(timeout = 4000)
    public void testShiftWithNegativeOffset() {
        byte[] array = new byte[]{1, 2, 3, 4, 5};
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = -1;

        // Perform the shift operation
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        
        // Verify the expected result after shifting
        assertArrayEquals(new byte[]{5, 1, 2, 3, 4}, array);
    }

    @Test(timeout = 4000)
    public void testShiftWithSingleElement() {
        byte[] array = new byte[]{1};
        int startIndexInclusive = 0;
        int endIndexExclusive = 1;
        int offset = 1;

        // Perform the shift operation
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        
        // Verify that the array remains unchanged
        assertArrayEquals(new byte[]{1}, array);
    }

}