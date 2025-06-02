package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_squeeze_String_String_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSqueezeWithNullString() {
        String result = CharSetUtils.squeeze(null, new String[]{"a", "b"});
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithEmptyStringAndNonNullSet() {
        String result = CharSetUtils.squeeze("", new String[]{"a", "b"});
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithEmptyStringAndEmptySet() {
        String result = CharSetUtils.squeeze("", new String[]{});
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNonEmptyStringAndNonEmptySet() {
        String result = CharSetUtils.squeeze("aaabbbccc", new String[]{"a", "b"});
        assertEquals("abc", result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNonEmptyStringAndNullSet() {
        String result = CharSetUtils.squeeze("aaabbbccc", null);
        assertEquals("abc", result);
    }

}