package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_keep_String_String_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testKeepWithEmptyString() {
        String result = CharSetUtils.keep("", "a", "b", "c");
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testKeepWithNullString() {
        String result = CharSetUtils.keep(null, "a", "b", "c");
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testKeepWithEmptySet() {
        String result = CharSetUtils.keep("test", new String[]{});
        assertEquals("", result);
    }

}