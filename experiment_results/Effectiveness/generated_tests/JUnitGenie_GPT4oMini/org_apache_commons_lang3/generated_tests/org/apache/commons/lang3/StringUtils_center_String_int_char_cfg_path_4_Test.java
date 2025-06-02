package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_center_String_int_char_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testCenterWithNullString() {
        String result = StringUtils.center(null, 10, '*');
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testCenterWithZeroSize() {
        String result = StringUtils.center("test", 0, '*');
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testCenterWithNegativeSize() {
        String result = StringUtils.center("test", -5, '*');
        assertEquals("test", result);
    }

}