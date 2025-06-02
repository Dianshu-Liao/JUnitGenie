package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtils_normalizeSpace_String_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpace() {
        // Test with a string that needs normalization
        String input = "   Hello   World  ";
        String expected = "Hello World";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithLeadingSpaces() {
        // Test with leading spaces
        String input = "   Java  Programming";
        String expected = "Java Programming";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithTrailingSpaces() {
        // Test with trailing spaces
        String input = "Python   ";
        String expected = "Python";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithMultipleSpaces() {
        // Test with multiple spaces between words
        String input = "Hello     World";
        String expected = "Hello World";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithNoSpaces() {
        // Test with no spaces
        String input = "NoSpacesHere";
        String expected = "NoSpacesHere";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithOnlySpaces() {
        // Test with a string that consists only of spaces
        String input = "       ";
        String expected = "";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithEmptyString() {
        // Test with an empty string
        String input = "";
        String expected = "";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

}