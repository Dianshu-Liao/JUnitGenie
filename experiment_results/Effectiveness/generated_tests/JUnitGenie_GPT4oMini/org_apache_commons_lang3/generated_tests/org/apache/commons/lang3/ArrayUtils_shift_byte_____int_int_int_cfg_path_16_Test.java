package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_shift_byte_____int_int_int_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testShift_withValidParameters() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = 2;
        
        // Expected outcome: the array should be shifted by 2 elements
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        assertArrayEquals(new byte[]{4, 5, 1, 2, 3}, array);
    }

    @Test(timeout = 4000)
    public void testShift_withOffsetLessThanZero() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = -2;
        
        // Expected outcome: the array should be shifted by 3 elements (5 - 2)
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        assertArrayEquals(new byte[]{3, 4, 5, 1, 2}, array);
    }

    @Test(timeout = 4000)
    public void testShift_withNoShiftNeeded() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = 0;
        
        // Expected outcome: the array should remain unchanged
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        assertArrayEquals(new byte[]{1, 2, 3, 4, 5}, array);
    }

    @Test(timeout = 4000)
    public void testShift_withInvalidStartIndex() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 5; // Invalid index
        int endIndexExclusive = 5;
        int offset = 1;
        
        // Expected outcome: no change should occur
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        assertArrayEquals(new byte[]{1, 2, 3, 4, 5}, array);
    }

    @Test(timeout = 4000)
    public void testShift_withArrayNull() {
        byte[] array = null;
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = 1;
        
        // Expected outcome: no change should occur (method returns without action)
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        // No assertion needed since we're testing for a no-op with null input
    }

}