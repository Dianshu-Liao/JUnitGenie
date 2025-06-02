package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_isSorted_byte_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testIsSortedWithArrayLengthLessThanTwo() {
        // Test case for an array with length less than 2
        byte[] array1 = new byte[] {};
        byte[] array2 = new byte[] {1};
        
        try {
            assertTrue(ArrayUtils.isSorted(array1));
            assertTrue(ArrayUtils.isSorted(array2));
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

}