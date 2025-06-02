package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_substringAfter_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSubstringAfter() {
        String str = "hello:world";
        String separator = ":";
        String expected = "world";
        
        String result = StringUtils.substringAfter(str, separator);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterWithEmptyString() {
        String str = "";
        String separator = ":";
        
        String result = StringUtils.substringAfter(str, separator);
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterWithNullSeparator() {
        String str = "hello:world";
        String separator = null;
        String expected = "";
        
        String result = StringUtils.substringAfter(str, separator);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterWithSeparatorNotFound() {
        String str = "hello world";
        String separator = ":";
        String expected = "";
        
        String result = StringUtils.substringAfter(str, separator);
        assertEquals(expected, result);
    }

}