package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testRightPad_NonNullInput() {
        String input = "abc";
        int size = 5;
        String padStr = "*";
        try {
            String result = StringUtils.rightPad(input, size, padStr);
            assertEquals("abc**", result);
        } catch (Exception e) {
            // Handle the exception if thrown
        }
    }
    
    @Test(timeout = 4000)
    public void testRightPad_EmptyPadStr() {
        String input = "abc";
        int size = 5;
        String padStr = "";
        try {
            String result = StringUtils.rightPad(input, size, padStr);
            assertEquals("abc  ", result); // Assuming SPACE is a single space character
        } catch (Exception e) {
            // Handle the exception if thrown
        }
    }

    @Test(timeout = 4000)
    public void testRightPad_EqualSize() {
        String input = "abc";
        int size = 3;
        String padStr = "*";
        try {
            String result = StringUtils.rightPad(input, size, padStr);
            assertEquals("abc", result);
        } catch (Exception e) {
            // Handle the exception if thrown
        }
    }

    @Test(timeout = 4000)
    public void testRightPad_PadLengthShorter() {
        String input = "abc";
        int size = 7;
        String padStr = "ab";
        try {
            String result = StringUtils.rightPad(input, size, padStr);
            assertEquals("abcabab", result);
        } catch (Exception e) {
            // Handle the exception if thrown
        }
    }

    @Test(timeout = 4000)
    public void testRightPad_PaddingOneCharacter() {
        String input = "abc";
        int size = 5;
        String padStr = "x";
        try {
            String result = StringUtils.rightPad(input, size, padStr);
            assertEquals("abcx", result);
        } catch (Exception e) {
            // Handle the exception if thrown
        }
    }

}