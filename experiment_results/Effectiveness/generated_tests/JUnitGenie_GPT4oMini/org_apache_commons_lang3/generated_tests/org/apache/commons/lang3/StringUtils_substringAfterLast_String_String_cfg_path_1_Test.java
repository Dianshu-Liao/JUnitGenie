package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_substringAfterLast_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSubstringAfterLast_validInputs() {
        String str = "www.example.com/index.html";
        String separator = ".";
        String expected = "html";
        String result = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLast_emptyString() {
        String str = "";
        String separator = ".";
        String expected = "";
        String result = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLast_emptySeparator() {
        String str = "www.example.com/index.html";
        String separator = "";
        String expected = "";
        String result = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLast_noSeparatorFound() {
        String str = "www.example.com/index.html";
        String separator = "/";
        String expected = "";
        String result = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLast_separatorAtEnd() {
        String str = "www.example.com/index.html";
        String separator = "html";
        String expected = "";
        String result = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLast_nullString() {
        String str = null;
        String separator = ".";
        String result = StringUtils.substringAfterLast(str, separator);
        assertNull(result);  // check for null return as str is null
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLast_nullSeparator() {
        String str = "www.example.com/index.html";
        String separator = null;
        String expected = "";
        String result = StringUtils.substringAfterLast(str, separator);
        assertEquals(expected, result);
    }

}