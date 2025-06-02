package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rightPad_String_int_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testRightPadWithNullString() {
        String result = StringUtils.rightPad(null, 10, " ");
        assertEquals(null, result);
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
    public void testRightPadWithExactPadLength() {
        String result = StringUtils.rightPad("test", 8, "xy");
        assertEquals("testxyxy", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithMorePadsThanPadStringLength() {
        String result = StringUtils.rightPad("test", 10, "xy");
        assertEquals("testxyxyxy", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithLessPadsThanPadStringLength() {
        String result = StringUtils.rightPad("test", 10, "xyz");
        assertEquals("testxyz", result);
    }

    @Test(timeout = 4000)
    public void testRightPadWithNoPaddingNeeded() {
        String result = StringUtils.rightPad("test", 4, " ");
        assertEquals("test", result);
    }

}