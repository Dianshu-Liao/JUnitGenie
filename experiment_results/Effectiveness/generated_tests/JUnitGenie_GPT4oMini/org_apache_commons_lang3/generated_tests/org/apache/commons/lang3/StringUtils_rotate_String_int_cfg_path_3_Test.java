package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rotate_String_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRotate() {
        // Test case for rotating a non-empty string with a positive shift
        String result = StringUtils.rotate("abcdef", 2);
        assertEquals("efabcd", result);

        // Test case for rotating a non-empty string with a shift equal to the string length
        result = StringUtils.rotate("abcdef", 6);
        assertEquals("abcdef", result);

        // Test case for rotating a non-empty string with a shift of zero
        result = StringUtils.rotate("abcdef", 0);
        assertEquals("abcdef", result);

        // Test case for rotating a non-empty string with a negative shift
        result = StringUtils.rotate("abcdef", -2);
        assertEquals("cdefab", result);

        // Test case for rotating an empty string
        result = StringUtils.rotate("", 3);
        assertEquals("", result);

        // Test case for rotating a null string
        result = StringUtils.rotate(null, 3);
        assertEquals(null, result);
    }

}