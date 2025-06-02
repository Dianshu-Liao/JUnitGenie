package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_substringsBetween_String_String_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSubstringsBetween() {
        String str = "abc[def]ghi[jkl]";
        String open = "[";
        String close = "]";
        
        // Expected output: ["def", "jkl"]
        String[] expected = new String[] {"def", "jkl"};
        
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
        
        try {
            String[] result = StringUtils.substringsBetween(str, open, close);
            assertArrayEquals(null, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithEmptyOpen() {
        String str = "abc[def]ghi";
        String open = "";
        String close = "]";
        
        try {
            String[] result = StringUtils.substringsBetween(str, open, close);
            assertArrayEquals(null, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithEmptyClose() {
        String str = "abc[def]ghi";
        String open = "[";
        String close = "";
        
        try {
            String[] result = StringUtils.substringsBetween(str, open, close);
            assertArrayEquals(null, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSubstringsBetweenWithNoMatches() {
        String str = "abcxyzghi";
        String open = "[";
        String close = "]";
        
        try {
            String[] result = StringUtils.substringsBetween(str, open, close);
            assertArrayEquals(null, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}