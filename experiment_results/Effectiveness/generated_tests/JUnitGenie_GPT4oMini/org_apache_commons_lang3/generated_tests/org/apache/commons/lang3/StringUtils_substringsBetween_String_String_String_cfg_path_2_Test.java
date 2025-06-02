package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_substringsBetween_String_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSubstringsBetween_NonNullInputs() {
        String str = "abc[def]ghi";
        String open = "[";
        String close = "]";
        String[] expected = {"def"};
        
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_EmptyString() {
        String str = "";
        String open = "[";
        String close = "]";
        
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_NullString() {
        String str = null;
        String open = "[";
        String close = "]";
        
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_EmptyOpen() {
        String str = "abc[def]ghi";
        String open = "";
        String close = "]";
        
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_EmptyClose() {
        String str = "abc[def]ghi";
        String open = "[";
        String close = "";
        
        String[] result = StringUtils.substringsBetween(str, open, close);
        assertArrayEquals(null, result);
    }

}