package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_removeElements_short_____short_____cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testRemoveElements_WithNonEmptyArrayAndEmptyValues() {
        short[] array = {1, 2, 3, 4, 5};
        short[] values = {}; // empty array, which must satisfy the constraints

        short[] result = ArrayUtils.removeElements(array, values);

        // Assert that the returned array is the same as the input array
        assertArrayEquals(array, result);
    }

}