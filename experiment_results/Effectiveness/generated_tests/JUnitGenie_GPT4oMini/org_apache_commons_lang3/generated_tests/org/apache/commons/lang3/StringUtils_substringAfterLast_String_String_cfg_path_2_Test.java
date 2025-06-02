package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_substringAfterLast_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSubstringAfterLast() {
        // Test case where str is non-empty and separator is non-empty
        String str = "abc/def/ghi";
        String separator = "/";
        String expected = "ghi";
        String actual = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLastWithEmptyStr() {
        // Test case where str is empty
        String str = "";
        String separator = "/";
        String expected = "";
        String actual = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLastWithEmptySeparator() {
        // Test case where separator is empty
        String str = "abc/def/ghi";
        String separator = "";
        String expected = "";
        String actual = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLastWithSeparatorNotFound() {
        // Test case where separator is not found
        String str = "abc/def/ghi";
        String separator = "x";
        String expected = "";
        String actual = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLastWithSeparatorAtEnd() {
        // Test case where separator is at the end of the string
        String str = "abc/def/";
        String separator = "/";
        String expected = "";
        String actual = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, actual);
    }

}