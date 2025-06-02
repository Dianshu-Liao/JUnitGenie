package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_squeeze_String_String_____cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testSqueezeWithNonEmptyStringAndSet() {
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
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(input, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNullString() {
        String input = null;
        String[] set = {"a", "b"};
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(input, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithEmptySet() {
        String input = "aaabbbccc";
        String[] set = {};
        String expected = "aaabbbccc";
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithOnlyOneCharacter() {
        String input = "aaaa";
        String[] set = {"a"};
        String expected = "a";
        String result = CharSetUtils.squeeze(input, set);
        assertEquals(expected, result);
    }

}