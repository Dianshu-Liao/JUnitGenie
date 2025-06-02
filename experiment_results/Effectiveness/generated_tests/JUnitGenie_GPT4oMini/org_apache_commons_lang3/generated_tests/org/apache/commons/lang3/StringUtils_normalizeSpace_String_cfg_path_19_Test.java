package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_normalizeSpace_String_cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithNullInput() {
        String input = null; // This input meets the constraint for isEmpty method
        String expected = null; // Expected output when input is null
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithEmptyString() {
        String input = ""; // This input is an empty string
        String expected = ""; // Expected output when input is an empty string
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithSpaces() {
        String input = "   "; // Input with only spaces
        String expected = ""; // Expected output should be an empty string
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithLeadingAndTrailingSpaces() {
        String input = "   Hello World!   "; // Input with leading and trailing spaces
        String expected = "Hello World!"; // Expected output should trim spaces
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpaceWithMultipleSpacesBetweenWords() {
        String input = "Hello    World!"; // Input with multiple spaces between words
        String expected = "Hello World!"; // Expected output should normalize spaces
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

}