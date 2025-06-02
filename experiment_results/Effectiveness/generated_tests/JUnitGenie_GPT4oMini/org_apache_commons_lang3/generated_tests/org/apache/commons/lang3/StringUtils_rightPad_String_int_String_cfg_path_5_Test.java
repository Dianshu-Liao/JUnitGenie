package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testRightPadWithSingleCharPadding() {
        String str = "abc";
        int size = 5;
        String padStr = "x";
        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("abcxx", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithMultipleCharPadding() {
        String str = "abc";
        int size = 6;
        String padStr = "xy";
        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("abcxy", result);
    }
    
    @Test(timeout = 4000)
    public void testRightPadWithNullPadStr() {
        String str = "abc";
        int size = 5;
        String padStr = null;
        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("abc  ", result); // SPACE is used as the default padding
    }

    @Test(timeout = 4000)
    public void testRightPadWithPadLengthGreaterThanPads() {
        String str = "abc";
        int size = 5;
        String padStr = "xyz";
        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("abcx", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithPadLengthEqualToPads() {
        String str = "abc";
        int size = 6;
        String padStr = "xy";
        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("abcxy", result);
    }
    
    @Test(timeout = 4000)
    public void testRightPadWithStrLongerThanSize() {
        String str = "abcdef";
        int size = 5;
        String padStr = "x";
        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("abcdef", result); // original string is returned
    }
    
    @Test(timeout = 4000)
    public void testRightPadWithMaxPadLimit() {
        String str = "abc";
        int size = 8185;
        String padStr = "x";
        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("abc" + StringUtils.repeat("x", 8182), result); // Use StringUtils.repeat instead of String.repeat
    }
    
    @Test(timeout = 4000)
    public void testRightPadReturnsNullForNullInput() {
        String str = null;
        int size = 5;
        String padStr = "x";
        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals(null, result); // should return null
    }


}