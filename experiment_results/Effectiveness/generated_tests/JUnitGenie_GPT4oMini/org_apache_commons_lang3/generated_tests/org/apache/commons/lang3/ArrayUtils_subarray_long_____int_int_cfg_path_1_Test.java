package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ArrayUtils_subarray_long_____int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSubarray_WithNullArray() {
        // Given
        long[] array = null;
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;

        // When
        long[] result = ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);

        // Then
        assertNull(result);
    }

}