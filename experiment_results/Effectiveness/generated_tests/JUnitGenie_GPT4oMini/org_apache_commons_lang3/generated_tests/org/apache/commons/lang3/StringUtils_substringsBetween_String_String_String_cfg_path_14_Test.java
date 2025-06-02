package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class StringUtils_substringsBetween_String_String_String_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testSubstringsBetween_ValidInput() {
        String str = "hello [world] and [everyone]";
        String open = "[";
        String close = "]";
        String[] expected = {"world", "everyone"};
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_EmptyInput() {
        String str = "";
        String open = "[";
        String close = "]";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_NoOpenOrClose() {
        String str = "hello world";
        String open = "(";
        String close = ")";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_NullString() {
        String[] result = StringUtils.substringsBetween(null, "[", "]");
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_EmptyOpenDelimiter() {
        String str = "hello [world]";
        String open = "";
        String close = "]";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_EmptyCloseDelimiter() {
        String str = "hello [world]";
        String open = "[";
        String close = "";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertNull(result);
    }


}