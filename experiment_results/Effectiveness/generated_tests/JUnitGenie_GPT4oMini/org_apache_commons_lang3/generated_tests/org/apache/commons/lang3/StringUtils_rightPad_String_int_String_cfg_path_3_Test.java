package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_rightPad_String_int_String_cfg_path_3_Test {

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
    public void testRightPadWithExactPadding() {
        String result = StringUtils.rightPad("test", 4, "xy");
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithLessPadding() {
        String result = StringUtils.rightPad("test", 8, "xy");
        assertEquals("testxy", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithMorePadding() {
        String result = StringUtils.rightPad("test", 10, "xy");
        assertEquals("testxyxy", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithLongerPadding() {
        String result = StringUtils.rightPad("test", 12, "xyz");
        assertEquals("testxyzxyz", result);
    }

}