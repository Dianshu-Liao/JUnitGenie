package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_substringsBetween_String_String_String_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testSubstringsBetween() {
        String str = "abc[def]ghi[jkl]";
        String open = "[";
        String close = "]";
        
        // Expected output: ["def", "jkl"]
        String[] expected = {"def", "jkl"};
        
        try {
            String[] result = StringUtils.substringsBetween(str, open, close);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithNoMatches() {
        String str = "abc[def]ghi";
        String open = "{";
        String close = "}";
        
        // Expected output: null
        String[] expected = null;
        
        try {
            String[] result = StringUtils.substringsBetween(str, open, close);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithNullStr() {
        String str = null;
        String open = "[";
        String close = "]";
        
        // Expected output: null
        String[] expected = null;
        
        try {
            String[] result = StringUtils.substringsBetween(str, open, close);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithEmptyString() {
        String str = "";
        String open = "[";
        String close = "]";
        
        // Expected output: empty array
        String[] expected = ArrayUtils.EMPTY_STRING_ARRAY;
        
        try {
            String[] result = StringUtils.substringsBetween(str, open, close);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithEmptyOpenClose() {
        String str = "abc[]ghi";
        String open = "";
        String close = "";
        
        // Expected output: null
        String[] expected = null;
        
        try {
            String[] result = StringUtils.substringsBetween(str, open, close);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}