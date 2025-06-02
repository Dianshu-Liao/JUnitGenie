package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_rotate_String_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testRotate_NullString() {
        String result = StringUtils.rotate(null, 5);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testRotate_ZeroShift() {
        String result = StringUtils.rotate("hello", 0);
        assertEquals("hello", result);
    }

    @Test(timeout = 4000)
    public void testRotate_EmptyString() {
        String result = StringUtils.rotate("", 5);
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testRotate_ShiftEqualToLength() {
        String result = StringUtils.rotate("hello", 5);
        assertEquals("hello", result);
    }

}