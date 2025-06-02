package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_normalizeSpace_String_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpace_EmptyString() {
        String input = ""; // This input will ensure that isEmpty returns true
        String expected = ""; // Expected output is also an empty string
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_NullInput() {
        String input = null; // This input will ensure that isEmpty returns true
        String expected = null; // Expected output is null
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_OnlyWhitespaces() {
        String input = "   "; // Input with only whitespaces
        String expected = ""; // Expected output is an empty string
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_SingleWord() {
        String input = "word"; // Input with a single word
        String expected = "word"; // Expected output is the same word
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_LeadingAndTrailingSpaces() {
        String input = "   word   "; // Input with leading and trailing spaces
        String expected = "word"; // Expected output is "word" without spaces
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_MultipleSpacesBetweenWords() {
        String input = "word1    word2"; // Input with multiple spaces between words
        String expected = "word1 word2"; // Expected output is "word1 word2" with a single space
        String result = StringUtils.normalizeSpace(input);
        assertEquals(expected, result);
    }

}