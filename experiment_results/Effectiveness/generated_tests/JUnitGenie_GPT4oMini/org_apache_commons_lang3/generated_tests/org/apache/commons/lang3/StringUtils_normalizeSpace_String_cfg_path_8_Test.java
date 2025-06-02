package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_normalizeSpace_String_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpace_withLeadingAndTrailingSpaces() {
        String input = "   Hello World!   ";
        String expected = "Hello World!";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_withMultipleSpaces() {
        String input = "Hello    World!";
        String expected = "Hello World!";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_withNonBreakingSpaces() {
        String input = "Hello\u00A0World!"; // Non-breaking space
        String expected = "Hello World!";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_withEmptyString() {
        String input = "";
        String expected = "";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_withNull() {
        String input = null;
        String expected = null;
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

}