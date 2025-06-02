package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_leftPad_String_int_char_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testLeftPadWithValidInput() {
        String result = StringUtils.leftPad("test", 8, ' ');
        assertEquals("   test", result);
    }

    @Test(timeout = 4000)
    public void testLeftPadWithNullString() {
        String result = StringUtils.leftPad(null, 8, ' ');
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testLeftPadWithSizeLessThanStringLength() {
        String result = StringUtils.leftPad("test", 2, ' ');
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testLeftPadWithExactSize() {
        String result = StringUtils.leftPad("test", 4, ' ');
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testLeftPadWithLargeSize() {
        String result = StringUtils.leftPad("test", 10, ' ');
        assertEquals("      test", result);
    }

}