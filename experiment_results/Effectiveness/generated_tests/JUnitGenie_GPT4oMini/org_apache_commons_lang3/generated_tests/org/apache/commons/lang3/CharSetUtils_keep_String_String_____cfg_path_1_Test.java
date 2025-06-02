package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_keep_String_String_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testKeepWithNonEmptyStringAndEmptySet() {
        String result = CharSetUtils.keep("test", new String[]{""});
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testKeepWithNullString() {
        String result = CharSetUtils.keep(null, new String[]{"a", "b"});
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testKeepWithEmptyString() {
        String result = CharSetUtils.keep("", new String[]{"a", "b"});
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testKeepWithEmptySet() {
        String result = CharSetUtils.keep("test", new String[]{});
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testKeepWithNonEmptyStringAndNonEmptySet() {
        String result = CharSetUtils.keep("test", new String[]{"a", "b", ""});
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testKeepWithDeepEmptySet() {
        try {
            String result = CharSetUtils.keep("test", new String[]{""});
            assertEquals("test", result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}