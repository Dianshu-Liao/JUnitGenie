package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_normalizeSpace_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpace() {
        // Test input with leading and trailing spaces
        String input = "   Hello World   ";
        String expected = "Hello World";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithMultipleSpaces() {
        // Test input with multiple spaces between words
        String input = "Hello    World";
        String expected = "Hello World";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithNonBreakingSpaces() {
        // Test input with non-breaking spaces
        String input = "Hello\u00A0World"; // \u00A0 is a non-breaking space
        String expected = "Hello World";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithEmptyString() {
        // Test input with an empty string
        String input = "";
        String expected = "";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithOnlySpaces() {
        // Test input with only spaces
        String input = "     ";
        String expected = "";
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithNull() {
        // Test input with null
        String input = null;
        String expected = null; // Assuming the method should return null for null input
        try {
            String result = StringUtils.normalizeSpace(input);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}