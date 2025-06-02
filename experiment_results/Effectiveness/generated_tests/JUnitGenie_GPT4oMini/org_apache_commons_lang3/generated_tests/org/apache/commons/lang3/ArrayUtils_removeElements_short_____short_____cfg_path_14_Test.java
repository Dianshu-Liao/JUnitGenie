package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Assert;
import org.junit.Test;

public class ArrayUtils_removeElements_short_____short_____cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testRemoveElements_WithNonEmptyArray_AndNoValues() {
        short[] array = {1, 2, 3, 4};
        short[] values = {}; // Empty values array to meet the constraints
        
        short[] result = ArrayUtils.removeElements(array, values);
        
        Assert.assertArrayEquals(new short[]{1, 2, 3, 4}, result); // Expecting the same array in the result
    }

    @Test(timeout = 4000)
    public void testRemoveElements_WithNonEmptyArray_AndMultipleValues() {
        short[] array = {1, 2, 3, 4, 2, 1};
        short[] values = {1, 2}; // Values to remove

        short[] result = ArrayUtils.removeElements(array, values);
        
        Assert.assertArrayEquals(new short[]{3, 4}, result); // 1's and 2's should be removed
    }

    @Test(timeout = 4000)
    public void testRemoveElements_WithNullValues() {
        short[] array = {1, 2, 3, 4};
        short[] values = null; // Null values array to meet the constraints
        
        short[] result = ArrayUtils.removeElements(array, values);
        
        Assert.assertArrayEquals(new short[]{1, 2, 3, 4}, result); // Expecting the same array in the result
    }

    @Test(timeout = 4000)
    public void testRemoveElements_WithEmptyArray() {
        short[] array = {}; // Empty input array
        short[] values = {1, 2}; // Values to remove
        
        short[] result = ArrayUtils.removeElements(array, values);
        
        Assert.assertArrayEquals(new short[]{}, result); // Expecting an empty array in the result
    }

    @Test(timeout = 4000)
    public void testRemoveElements_WithNullArray() {
        short[] array = null; // Null input array
        short[] values = {1, 2};

        try {
            ArrayUtils.removeElements(array, values);
            Assert.fail("Expected an NullPointerException to be thrown"); // Ensure exception is expected
        } catch (NullPointerException e) {
            // Exception is expected
        }
    }

}