package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_String_cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testRightPadWithNullPadStr() {
        String str = "test";
        int size = 10;
        String padStr = null;

        // Expected output: "test      " (padded with spaces)
        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("test      ", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithEmptyPadStr() {
        String str = "test";
        int size = 10;
        String padStr = "";

        // Expected output: "test      " (padded with spaces)
        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("test      ", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithSingleCharacterPadStr() {
        String str = "test";
        int size = 10;
        String padStr = "*";

        // Expected output: "test******" (padded with asterisks)
        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("test******", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithLongPadStr() {
        String str = "test";
        int size = 10;
        String padStr = "abc";

        // Expected output: "testabcab" (padded with "abc")
        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("testabcab", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithExactSize() {
        String str = "test";
        int size = 4;
        String padStr = "abc";

        // Expected output: "test" (no padding needed)
        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithMorePaddingThanPadStrLength() {
        String str = "test";
        int size = 10;
        String padStr = "ab";

        // Expected output: "testababab" (padded with "ab")
        String result = StringUtils.rightPad(str, size, padStr);
        assertEquals("testababab", result);
    }

}