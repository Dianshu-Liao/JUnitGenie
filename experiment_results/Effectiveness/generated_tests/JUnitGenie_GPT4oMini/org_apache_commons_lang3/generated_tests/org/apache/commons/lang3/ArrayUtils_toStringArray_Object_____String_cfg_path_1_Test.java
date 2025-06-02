package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toStringArray_Object_____String_cfg_path_1_Test {

    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    @Test(timeout = 4000)
    public void testToStringArrayWithNonEmptyArray() {
        Object[] inputArray = {1, null, "test", 4.5};
        String valueForNullElements = "nullValue";
        String[] expectedOutput = {"1", "nullValue", "test", "4.5"};
        String[] actualOutput = ArrayUtils.toStringArray(inputArray, valueForNullElements);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testToStringArrayWithNullArray() {
        Object[] inputArray = null;
        String valueForNullElements = "nullValue";
        String[] actualOutput = ArrayUtils.toStringArray(inputArray, valueForNullElements);
        assertArrayEquals(null, actualOutput);
    }

    @Test(timeout = 4000)
    public void testToStringArrayWithEmptyArray() {
        Object[] inputArray = new Object[0];
        String valueForNullElements = "nullValue";
        String[] actualOutput = ArrayUtils.toStringArray(inputArray, valueForNullElements);
        assertArrayEquals(EMPTY_STRING_ARRAY, actualOutput);
    }

    @Test(timeout = 4000)
    public void testToStringArrayWithOnlyNullElements() {
        Object[] inputArray = {null, null, null};
        String valueForNullElements = "nullValue";
        String[] expectedOutput = {"nullValue", "nullValue", "nullValue"};
        String[] actualOutput = ArrayUtils.toStringArray(inputArray, valueForNullElements);
        assertArrayEquals(expectedOutput, actualOutput);
    }

}