package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_squeeze_String_String_____cfg_path_11_Test {

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
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithDeepEmptySet() {
        String input = "aaabbbccc";
        String[] set = {};
        String expected = "aaabbbccc";
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNullSet() {
        String input = "aaabbbccc";
        String[] set = null;
        String expected = "aaabbbccc";
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNoConsecutiveChars() {
        String input = "abc";
        String[] set = {"a", "b"};
        String expected = "abc";
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithAllSameChars() {
        String input = "aaaaaa";
        String[] set = {"a"};
        String expected = "a";
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithMixedChars() {
        String input = "aabbccddeeff";
        String[] set = {"a", "b", "c"};
        String expected = "abcde";
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithSpecialChars() {
        String input = "aa!!bb!!cc";
        String[] set = {"!"};
        String expected = "a!b!c";
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

}