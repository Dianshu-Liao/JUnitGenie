package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_normalizeSpace_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpace() {
        // Test case for a non-empty string with multiple spaces
        String input = "   Hello   World   ";
        String expected = "Hello World";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithLeadingAndTrailingSpaces() {
        // Test case for a string with leading and trailing spaces
        String input = "   Java Programming   ";
        String expected = "Java Programming";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithNoSpaces() {
        // Test case for a string with no spaces
        String input = "JUnit";
        String expected = "JUnit";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithEmptyString() {
        // Test case for an empty string
        String input = "";
        String expected = "";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithOnlySpaces() {
        // Test case for a string that contains only spaces
        String input = "       ";
        String expected = "";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithNonBreakingSpaces() {
        // Test case for a string with non-breaking spaces
        String input = "\u00A0Hello\u00A0World\u00A0";
        String expected = "Hello World";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

}