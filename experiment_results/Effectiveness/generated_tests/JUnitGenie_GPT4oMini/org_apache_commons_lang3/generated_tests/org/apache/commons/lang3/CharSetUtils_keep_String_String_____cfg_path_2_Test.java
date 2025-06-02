package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_keep_String_String_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testKeepWithNullStringAndNullSet() {
        String result = CharSetUtils.keep(null, (String[]) null);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testKeepWithEmptyStringAndNullSet() {
        String result = CharSetUtils.keep("", (String[]) null);
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testKeepWithEmptyStringAndEmptySet() {
        String result = CharSetUtils.keep("", new String[]{});
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testKeepWithNonEmptyStringAndNullSet() {
        String result = CharSetUtils.keep("test", (String[]) null);
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testKeepWithNonEmptyStringAndSetContainingOnlyNulls() {
        String result = CharSetUtils.keep("test", new String[]{null, null});
        assertEquals("", result);
    }

}