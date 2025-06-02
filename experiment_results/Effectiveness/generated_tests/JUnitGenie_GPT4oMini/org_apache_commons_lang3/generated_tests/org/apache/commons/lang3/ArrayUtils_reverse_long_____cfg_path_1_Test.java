package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_reverse_long_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReverseWithValidArray() {
        long[] array = {1, 2, 3, 4, 5};
        ArrayUtils.reverse(array);
        assertArrayEquals(new long[]{5, 4, 3, 2, 1}, array);
    }

    @Test(timeout = 4000)
    public void testReverseWithNullArray() {
        try {
            ArrayUtils.reverse((long[]) null); // Cast to long[] to resolve ambiguity
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testReverseWithEmptyArray() {
        long[] array = {};
        ArrayUtils.reverse(array);
        assertArrayEquals(new long[]{}, array);
    }


}