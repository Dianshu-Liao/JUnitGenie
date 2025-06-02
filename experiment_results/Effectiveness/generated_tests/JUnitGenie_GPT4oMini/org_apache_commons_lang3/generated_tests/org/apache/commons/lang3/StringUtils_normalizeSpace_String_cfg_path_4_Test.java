package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_normalizeSpace_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpace() {
        // Test case for a string with leading and trailing spaces
        String input = "   Hello World!   ";
        String expected = "Hello World!";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);

        // Test case for a string with multiple spaces between words
        input = "Hello    World!";
        expected = "Hello World!";
        result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);

        // Test case for a string with no spaces
        input = "HelloWorld!";
        expected = "HelloWorld!";
        result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);

        // Test case for an empty string
        input = "";
        expected = "";
        result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);

        // Test case for a string with only spaces
        input = "     ";
        expected = "";
        result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);

        // Test case for a string with non-breaking spaces
        input = "Hello\u00A0World!";
        expected = "Hello World!";
        result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

}