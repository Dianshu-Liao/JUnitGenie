package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_substringsBetween_String_String_String_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testSubstringsBetween_ValidInput() {
        String str = "abc[def]ghi[jkl]";
        String open = "[";
        String close = "]";
        String[] expected = {"def", "jkl"};
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_NoSubstrings() {
        String str = "abc-def-ghi";
        String open = "[";
        String close = "]";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_EmptyString() {
        String str = "";
        String open = "[";
        String close = "]";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertArrayEquals(new String[0], result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_NullString() {
        String str = null;
        String open = "[";
        String close = "]";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_EmptyOpen() {
        String str = "abc[def]ghi";
        String open = "";
        String close = "]";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_EmptyClose() {
        String str = "abc[def]ghi";
        String open = "[";
        String close = "";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_OpenNotFound() {
        String str = "abc-def-ghi";
        String open = "{";
        String close = "}";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_CloseNotFound() {
        String str = "abc[def-ghi";
        String open = "[";
        String close = "]";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertNull(result);
    }

}