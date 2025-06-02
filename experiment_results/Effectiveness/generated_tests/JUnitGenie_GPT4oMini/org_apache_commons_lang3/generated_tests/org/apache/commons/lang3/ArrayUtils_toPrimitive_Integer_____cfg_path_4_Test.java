package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class ArrayUtils_toPrimitive_Integer_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        try {
            Integer[] input = null; // Define an Integer array
            int[] result = ArrayUtils.toPrimitive(input); // Convert Integer array to primitive int array
            assertNull(result);
        } catch (Exception e) {
            // Handle expected exceptions here
        }
    }


}