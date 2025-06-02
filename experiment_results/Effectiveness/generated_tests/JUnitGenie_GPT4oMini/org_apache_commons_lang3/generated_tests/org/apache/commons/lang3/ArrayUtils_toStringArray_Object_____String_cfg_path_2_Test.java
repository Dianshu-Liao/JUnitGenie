package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toStringArray_Object_____String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToStringArrayWithEmptyArray() {
        // Given
        Object[] inputArray = {};
        String valueForNullElements = "null";

        // When
        String[] result = ArrayUtils.toStringArray(inputArray, valueForNullElements);

        // Then
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result);
    }

}