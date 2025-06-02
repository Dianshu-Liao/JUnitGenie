package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_normalizeSpace_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpace() {
        // Test case for a string with leading and trailing spaces
        String input = "   Hello World!   ";
        String expected = "Hello World!";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithMultipleSpaces() {
        // Test case for a string with multiple spaces between words
        String input = "Hello    World!";
        String expected = "Hello World!";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithNonBreakingSpaces() {
        // Test case for a string with non-breaking spaces
        String input = "Hello\u00A0World!";
        String expected = "Hello World!";
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
    public void testNormalizeSpaceWithNull() {
        // Test case for null input
        String input = null;
        String expected = null; // Assuming the method should return null for null input
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

}