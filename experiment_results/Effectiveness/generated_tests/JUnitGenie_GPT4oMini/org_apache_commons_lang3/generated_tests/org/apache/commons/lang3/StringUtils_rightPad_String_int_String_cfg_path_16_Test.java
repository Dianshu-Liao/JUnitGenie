package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_rightPad_String_int_String_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testRightPadWithNullString() {
        String result = StringUtils.rightPad(null, 5, " ");
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithEmptyPadString() {
        String result = StringUtils.rightPad("test", 10, "");
        assertEquals("test     ", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithSingleCharacterPad() {
        String result = StringUtils.rightPad("test", 10, "x");
        assertEquals("testxxxxxx", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithPadStringLongerThanPads() {
        String result = StringUtils.rightPad("test", 10, "abcdef");
        assertEquals("testabcde", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithExactPadLength() {
        String result = StringUtils.rightPad("test", 8, "xy");
        assertEquals("testxy", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithMorePadsThanPadLength() {
        String result = StringUtils.rightPad("test", 12, "xy");
        assertEquals("testxyxyxy", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithNoPaddingNeeded() {
        String result = StringUtils.rightPad("test", 4, " ");
        assertEquals("test", result);
    }

}