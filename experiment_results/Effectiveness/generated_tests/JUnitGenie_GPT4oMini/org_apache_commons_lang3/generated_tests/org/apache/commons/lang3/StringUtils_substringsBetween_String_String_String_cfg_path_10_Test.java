package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_substringsBetween_String_String_String_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithNullStr() {
        String str = null;
        String open = "<";
        String close = ">";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithEmptyOpen() {
        String str = "Hello <world>";
        String open = "";
        String close = ">";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithEmptyClose() {
        String str = "Hello <world>";
        String open = "<";
        String close = "";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithNoSubstrings() {
        String str = "Hello world";
        String open = "<";
        String close = ">";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithValidInput() {
        String str = "Hello <world> and <everyone>";
        String open = "<";
        String close = ">";
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertArrayEquals(new String[]{"world", "everyone"}, result);
    }

}