package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Boolean_____boolean_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithEmptyArray() {
        // Given
        Boolean[] inputArray = {};
        boolean valueForNull = false; // Value to return for nulls

        // When
        boolean[] result = ArrayUtils.toPrimitive(inputArray, valueForNull);

        // Then
        assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, result);
    }

}