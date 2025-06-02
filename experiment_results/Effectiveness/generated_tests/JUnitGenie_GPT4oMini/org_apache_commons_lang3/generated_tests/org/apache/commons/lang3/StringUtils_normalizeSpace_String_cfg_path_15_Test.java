package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtils_normalizeSpace_String_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpace_EmptyString() {
        String input = ""; // This input ensures that isEmpty returns true
        String expected = ""; // Since the input is empty, the expected output should also be empty

        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }
    
    @Test(timeout = 4000)
    public void testNormalizeSpace_NonEmptyString() {
        String input = "   Hello   World   "; // Input with leading, trailing, and multiple spaces
        String expected = "Hello World"; // Expected output should normalize spaces

        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_SingleWhitespace() {
        String input = " "; // Test input is a single whitespace
        String expected = ""; // Expected output should be empty since there's no non-whitespace character

        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

}