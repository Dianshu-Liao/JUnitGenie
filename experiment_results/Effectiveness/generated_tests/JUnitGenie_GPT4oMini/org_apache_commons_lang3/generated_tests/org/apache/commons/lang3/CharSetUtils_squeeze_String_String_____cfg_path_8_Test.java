package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_squeeze_String_String_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testSqueezeWithValidInput() {
        String input = "aaabbbccc";
        String[] set = {"a", "b"};
        String expected = "abc";
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithEmptyString() {
        String input = "";
        String[] set = {"a", "b"};
        String expected = "";
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNullString() {
        String input = null;
        String[] set = {"a", "b"};
        String expected = null;
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithDeepEmptySet() {
        String input = "aaabbbccc";
        String[] set = {""}; // deepEmpty condition
        String expected = "aaabbbccc"; // should return the original string
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNoRepetitions() {
        String input = "abc";
        String[] set = {"a", "b"};
        String expected = "abc"; // no characters to squeeze
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithAllSameCharacters() {
        String input = "aaaaaa";
        String[] set = {"a"};
        String expected = "a"; // should squeeze to a single character
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithMixedCharacters() {
        String input = "aaabbaaaccc";
        String[] set = {"a", "b"};
        String expected = "abc"; // should squeeze to abc
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNullSet() {
        String input = "aaabbbccc";
        String[] set = null; // should not affect the input
        String expected = "aaabbbccc"; // should return the original string
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

}