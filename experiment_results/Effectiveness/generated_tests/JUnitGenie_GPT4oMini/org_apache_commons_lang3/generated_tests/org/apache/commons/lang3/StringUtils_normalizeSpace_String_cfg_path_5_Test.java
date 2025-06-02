package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_normalizeSpace_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithSpaces() {
        String input = "   Hello   World!   ";
        String expected = "Hello World!";
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithNonWhitespaceChars() {
        String input = "HelloWorld";
        String expected = "HelloWorld";
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithEmptyString() {
        String input = "";
        String expected = "";
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithOnlyWhitespace() {
        String input = "       ";
        String expected = "";
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithLeadingAndTrailingSpaces() {
        String input = "   Leading and Trailing Spaces   ";
        String expected = "Leading and Trailing Spaces";
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithNonBreakingSpaces() {
        String input = "\u00A0Hello\u00A0World\u00A0";
        String expected = "Hello World";
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithMixedWhitespace() {
        String input = "Hello\u00A0  World!    ";
        String expected = "Hello World!";
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

}