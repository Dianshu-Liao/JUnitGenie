package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_rightPad_String_int_String_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testRightPadWithNullStringAndDefaultPad() {
        String result = StringUtils.rightPad(null, 10, null);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithEmptyPadString() {
        String result = StringUtils.rightPad("test", 10, "");
        assertEquals("test      ", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithSingleCharacterPad() {
        String result = StringUtils.rightPad("test", 10, "x");
        assertEquals("testxxxxxx", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithLongerPadString() {
        String result = StringUtils.rightPad("test", 10, "abc");
        assertEquals("testabcab", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithExactPadding() {
        String result = StringUtils.rightPad("test", 4, "x");
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithMorePaddingThanPadString() {
        String result = StringUtils.rightPad("test", 10, "xy");
        assertEquals("testxyxyxy", result);
    }

}