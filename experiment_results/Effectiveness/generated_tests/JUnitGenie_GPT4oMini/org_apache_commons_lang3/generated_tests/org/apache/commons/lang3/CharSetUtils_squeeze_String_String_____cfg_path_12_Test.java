package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_squeeze_String_String_____cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testSqueezeWithNonEmptyStringAndEmptySet() {
        String input = "aaabbbccc";
        String[] set = new String[] {}; // empty set
        String expected = "abc";
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNullString() {
        String input = null;
        String[] set = new String[] { "a", "b" };
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithEmptyString() {
        String input = "";
        String[] set = new String[] { "a", "b" };
        String result = CharSetUtils.squeeze(input, set);
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithDeepEmptySet() {
        String input = "aaabbbccc";
        String[] set = new String[] { "", null }; // deep empty set
        String expected = "abc";
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithRepeatedCharacters() {
        String input = "aaaabbbbcccc";
        String[] set = new String[] { "a", "b" };
        String expected = "abc";
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNoRepetitions() {
        String input = "abc";
        String[] set = new String[] { "x", "y" };
        String expected = "abc";
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

}