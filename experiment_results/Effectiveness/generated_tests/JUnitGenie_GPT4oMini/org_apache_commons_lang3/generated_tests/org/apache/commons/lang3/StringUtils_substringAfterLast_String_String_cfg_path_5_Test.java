package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_substringAfterLast_String_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSubstringAfterLast_withNonEmptyStringAndSeparator() {
        String str = "abc-def-ghi";
        String separator = "-";
        String expected = "ghi";
        String result = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLast_withEmptyString() {
        String str = "";
        String separator = "-";
        String expected = "";
        String result = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLast_withEmptySeparator() {
        String str = "abc-def-ghi";
        String separator = "";
        String expected = "";
        String result = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLast_withSeparatorNotFound() {
        String str = "abc-def-ghi";
        String separator = "x";
        String expected = "";
        String result = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLast_withSeparatorAtEnd() {
        String str = "abc-def-";
        String separator = "-";
        String expected = "";
        String result = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, result);
    }

}