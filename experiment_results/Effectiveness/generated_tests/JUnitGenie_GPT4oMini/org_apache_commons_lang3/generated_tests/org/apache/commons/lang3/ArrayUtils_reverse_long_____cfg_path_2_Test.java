package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_reverse_long_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReverseWithNullArray() {
        try {
            long[] array = null;
            ArrayUtils.reverse(array);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}