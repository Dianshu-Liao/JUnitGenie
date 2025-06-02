package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_substringsBetween_String_String_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSubstringsBetween() {
        String str = "abc[def]ghi[jkl]";
        String open = "[";
        String close = "]";
        
        String[] expected = {"def", "jkl"};
        String[] result = StringUtils.substringsBetween(str, open, close);
        
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithEmptyString() {
        String str = "";
        String open = "[";
        String close = "]";
        
        String[] result = StringUtils.substringsBetween(str, open, close);
        
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithNullString() {
        String str = null;
        String open = "[";
        String close = "]";
        
        String[] result = StringUtils.substringsBetween(str, open, close);
        
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithEmptyOpen() {
        String str = "abc[]ghi";
        String open = "";
        String close = "]";
        
        String[] result = StringUtils.substringsBetween(str, open, close);
        
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithEmptyClose() {
        String str = "abc[def]ghi";
        String open = "[";
        String close = "";
        
        String[] result = StringUtils.substringsBetween(str, open, close);
        
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithNoMatches() {
        String str = "abcxyzghi";
        String open = "[";
        String close = "]";
        
        String[] result = StringUtils.substringsBetween(str, open, close);
        
        assertArrayEquals(null, result);
    }

}